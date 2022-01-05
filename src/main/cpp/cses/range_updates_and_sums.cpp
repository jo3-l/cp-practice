#include <bits/stdc++.h>

using namespace std;
using ll = long long;

constexpr int MN = 200'000;

ll t[MN * 4];
ll lazy_add[MN * 4], lazy_set[MN * 4], orig[MN];

void build(int v, int l, int r) {
	if (l == r) {
		t[v] = orig[l];
	} else {
		int m = (l + r) / 2;
		build(v * 2, l, m);
		build(v * 2 + 1, m + 1, r);
		t[v] = t[v * 2] + t[v * 2 + 1];
	}
}

void push(int v, int l_sz, int r_sz) {
	if (lazy_set[v]) {
		lazy_set[v * 2] = lazy_set[v * 2 + 1] = lazy_set[v];
		t[v * 2] = lazy_set[v] * l_sz;
		t[v * 2 + 1] = lazy_set[v] * r_sz;
		lazy_add[v * 2] = lazy_add[v * 2 + 1] = 0;
		lazy_set[v] = 0;
	} else if (lazy_add[v]) {
		if (lazy_set[v * 2]) {
			lazy_set[v * 2] += lazy_add[v];
			lazy_add[v * 2] = 0;
		} else {
			lazy_add[v * 2] += lazy_add[v];
		}
		if (lazy_set[v * 2 + 1]) {
			lazy_set[v * 2 + 1] += lazy_add[v];
			lazy_add[v * 2 + 1] = 0;
		} else {
			lazy_add[v * 2 + 1] += lazy_add[v];
		}
		t[v * 2] += lazy_add[v] * l_sz;
		t[v * 2 + 1] += lazy_add[v] * r_sz;
		lazy_add[v] = 0;
	}
}

void set_all(int v, int ql, int qr, int tl, int tr, int new_v) {
	if (ql > qr) return;
	if (ql == tl && qr == tr) {
		lazy_set[v] = new_v;
		lazy_add[v] = 0;
		t[v] = (ll)new_v * (qr - ql + 1);
	} else {
		int tm = (tl + tr) / 2;
		push(v, tm - tl + 1, tr - tm);
		set_all(v * 2, ql, min(qr, tm), tl, tm, new_v);
		set_all(v * 2 + 1, max(tm + 1, ql), qr, tm + 1, tr, new_v);
		t[v] = t[v * 2] + t[v * 2 + 1];
	}
}

void add_all(int v, int ql, int qr, int tl, int tr, int addend) {
	if (ql > qr) return;
	if (ql == tl && qr == tr) {
		if (lazy_set[v]) lazy_set[v] += addend;
		else lazy_add[v] += addend;
		t[v] += (ll)addend * (qr - ql + 1);
	} else {
		int tm = (tl + tr) / 2;
		push(v, tm - tl + 1, tr - tm);
		add_all(v * 2, ql, min(qr, tm), tl, tm, addend);
		add_all(v * 2 + 1, max(tm + 1, ql), qr, tm + 1, tr, addend);
		t[v] = t[v * 2] + t[v * 2 + 1];
	}
}

ll query(int v, int ql, int qr, int tl, int tr) {
	if (ql > qr) return 0;
	if (ql == tl && qr == tr) return t[v];
	int tm = (tl + tr) / 2;
	push(v, tm - tl + 1, tr - tm);
	ll left_ans = query(v * 2, ql, min(qr, tm), tl, tm);
	ll right_ans = query(v * 2 + 1, max(tm + 1, ql), qr, tm + 1, tr);
	return left_ans + right_ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, q;
	cin >> n >> q;
	for (int i = 0; i < n; i++) cin >> orig[i];
	build(1, 0, n - 1);

	while (q--) {
		int typ, a, b, x;
		cin >> typ >> a >> b;
		a--;
		b--; // 1-based to 0-based
		if (typ == 1) {
			cin >> x;
			add_all(1, a, b, 0, n - 1, x);
		} else if (typ == 2) {
			cin >> x;
			set_all(1, a, b, 0, n - 1, x);
		} else {
			cout << query(1, a, b, 0, n - 1) << '\n';
		}
	}

	return 0;
}