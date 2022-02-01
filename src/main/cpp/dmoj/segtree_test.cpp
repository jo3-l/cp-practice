#include <bits/stdc++.h>

using namespace std;

struct Node {
	Node() : gcd(0), min(0), eq_to_gcd(0) {}
	Node(int gcd_, int min_, int eq_to_gcd_) : gcd(gcd_), min(min_), eq_to_gcd(eq_to_gcd_) {}

	int gcd;
	int min;
	int eq_to_gcd;

	friend Node operator+(const Node &lhs, const Node &rhs) {
		Node out;
		if (lhs.gcd == -1) out.gcd = rhs.gcd;
		else if (rhs.gcd == -1) out.gcd = lhs.gcd;
		else out.gcd = __gcd(lhs.gcd, rhs.gcd);

		out.min = std::min(lhs.min, rhs.min);

		if (out.gcd == lhs.gcd) out.eq_to_gcd += lhs.eq_to_gcd;
		if (out.gcd == rhs.gcd) out.eq_to_gcd += rhs.eq_to_gcd;
		return out;
	}
};

constexpr int MN = 100'001;
Node t[4 * MN];
int init_val[MN];

void build(int v, int l, int r) {
	if (l == r) {
		t[v].gcd = t[v].min = init_val[l];
		t[v].eq_to_gcd = 1;
	} else {
		int m = (l + r) / 2;
		build(v * 2, l, m);
		build(v * 2 + 1, m + 1, r);
		t[v] = t[v * 2] + t[v * 2 + 1];
	}
}

void update(int v, int t_l, int t_r, int upd_i, int upd_v) {
	if (t_l > t_r) return;
	if (t_l == t_r) {
		t[v].min = t[v].gcd = upd_v;
	} else {
		int t_m = (t_l + t_r) / 2;
		if (upd_i <= t_m) update(v * 2, t_l, t_m, upd_i, upd_v);
		else update(v * 2 + 1, t_m + 1, t_r, upd_i, upd_v);
		t[v] = t[v * 2] + t[v * 2 + 1];
	}
}

constexpr int INF = 0x3f3f3f3f;

Node query(int v, int t_l, int t_r, int l, int r) {
	if (l > r) return {-1, INF, 0};
	if (t_l == l && t_r == r) return t[v];
	int t_m = (t_l + t_r) / 2;
	return query(v * 2, t_l, t_m, l, min(r, t_m)) + query(v * 2 + 1, t_m + 1, t_r, max(l, t_m + 1), r);
}

int n, m;

void solve() {
	char q;
	int x, y;
	cin >> q >> x >> y;
	if (q == 'C') update(1, 1, n, x, y);
	else if (q == 'M') cout << query(1, 1, n, x, y).min << '\n';
	else if (q == 'G') cout << query(1, 1, n, x, y).gcd << '\n';
	else cout << query(1, 1, n, x, y).eq_to_gcd << '\n';
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	cin >> n >> m;
	for (int i = 1; i <= n; i++) cin >> init_val[i];
	build(1, 1, n);
	while (m--) solve();

	return 0;
}