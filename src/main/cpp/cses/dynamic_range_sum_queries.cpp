#include <bits/stdc++.h>

using namespace std;
using ll = long long;

ll bit[200'001];
int n;

void add(int i, int v) {
	for (++i; i < n; i += i & -i) bit[i] += v;
}

ll query(int i) {
	ll ans = 0;
	for (++i; i > 0; i -= i & -i) ans += bit[i];
	return ans;
}

ll query(int a, int b) { return query(b) - query(a - 1); }

int get(int idx) { return query(idx, idx); }

void upd(int idx, int v) { add(idx, v - get(idx)); }

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int q;
	cin >> n >> q;
	n++;
	for (int i = 0; i < n - 1; i++) {
		int x;
		cin >> x;
		add(i, x);
	}
	while (q--) {
		int t, x, y;
		cin >> t >> x >> y;
		if (t == 1) upd(x - 1, y);
		else cout << query(x - 1, y - 1) << '\n';
	}

	return 0;
}