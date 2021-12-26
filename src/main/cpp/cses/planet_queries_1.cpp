#include <bits/stdc++.h>

using namespace std;

int t[200'001][31];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, q;
	cin >> n >> q;
	for (int i = 1; i <= n; i++) cin >> t[i][0];
	for (int k = 1; k <= 30; k++) {
		for (int i = 1; i <= n; i++) t[i][k] = t[t[i][k - 1]][k - 1];
	}
	while (q--) {
		int x, k;
		cin >> x >> k;
		int d = x;
		for (; k > 0; k &= k - 1) d = t[d][__builtin_ctz(k)];
		cout << d << '\n';
	}

	return 0;
}