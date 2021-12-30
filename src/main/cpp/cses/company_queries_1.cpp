#include <bits/stdc++.h>

using namespace std;

int anc[200'001][19];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, q;
	cin >> n >> q;
	anc[1][0] = -1;
	for (int i = 2; i <= n; i++) cin >> anc[i][0];
	for (int k = 1; k <= 32 - __builtin_clz(n); k++) {
		for (int i = 1; i <= n; i++) {
			anc[i][k] = anc[i][k - 1];
			if (anc[i][k] != -1) anc[i][k] = anc[anc[i][k]][k - 1];
		}
	}
	while (q--) {
		int x, k;
		cin >> x >> k;
		for (; x != -1 && k > 0; k &= k - 1) x = anc[x][__builtin_ctz(k)];
		cout << x << '\n';
	}
	return 0;
}