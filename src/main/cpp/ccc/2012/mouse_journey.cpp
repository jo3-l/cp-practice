#include <bits/stdc++.h>

using namespace std;

constexpr int MR = 25, MC = 25;
int dp[MR][MC];
bool cats[MR][MC];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int r, c, k;
	cin >> r >> c >> k;
	while (k--) {
		int i, j;
		cin >> i >> j;
		cats[i - 1][j - 1] = true;
	}

	dp[0][0] = 1;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if ((i == 0 && j == 0) || cats[i][j]) continue;
			dp[i][j] = (i > 0 ? dp[i - 1][j] : 0) + (j > 0 ? dp[i][j - 1] : 0);
		}
	}

	cout << dp[r - 1][c - 1] << '\n';
	return 0;
}