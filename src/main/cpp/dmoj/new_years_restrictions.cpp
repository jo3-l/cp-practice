#include <bits/stdc++.h>

using namespace std;

int cannot_if[18];

bool possible(int msk) {
	for (int m = msk; m > 0; m &= m - 1) {
		if (msk & cannot_if[__builtin_ctz(m)]) return false;
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, m;
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		cannot_if[x - 1] |= 1 << (y - 1);
	}
	int ans = 0;
	for (int msk = 0; msk < (1 << n); msk++) {
		if (possible(msk)) ans = max(ans, __builtin_popcount(msk));
	}

	cout << ans << '\n';
	return 0;
}