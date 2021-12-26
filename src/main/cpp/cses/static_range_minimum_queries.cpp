#include <bits/stdc++.h>

using namespace std;

int t[200'000][18];

int query(int a, int b) {
	int k = 31 - __builtin_clz(b - a + 1);
	return min(t[a][k], t[b - (1 << k) + 1][k]);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, q;
	cin >> n >> q;
	for (int i = 0; i < n; i++) cin >> t[i][0];
	for (int k = 1; k <= 32 - __builtin_clz(n - 1); k++) {
		for (int i = 0; i + (1 << k) <= n; i++) t[i][k] = min(t[i][k - 1], t[i + (1 << (k - 1))][k - 1]);
	}
	while (q--) {
		int a, b;
		cin >> a >> b;
		cout << query(a - 1, b - 1) << '\n';
	}

	return 0;
}