#include <bits/stdc++.h>

using namespace std;
using ull = unsigned long long;

bool dp[301][300][300];
char mem[300][300];
int r, c;

// r1[c1:c2] == reversed(r2[c1:c2])
bool is_row_reversed(int r1, int r2, int c1, int c2) {
	int stop_c1 = c2;
	while (c1 <= stop_c1) {
		if (mem[r1][c1++] != mem[r2][c2--]) return false;
	}
	return true;
}

// c1[r1:r2] == reversed(c2[r1:2])
bool is_col_reversed(int c1, int c2, int r1, int r2) {
	int stop_r1 = r2;
	while (r1 <= stop_r1) {
		if (mem[r1++][c1] != mem[r2--][c2]) return false;
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	memset(dp[0], true, sizeof(dp[0]));
	memset(dp[1], true, sizeof(dp[1]));

	cin >> r >> c;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) cin >> mem[i][j];
	}

	int ans = -1;
	for (int sz = 2; sz <= min(r, c); sz++) {
		for (int i = sz - 1; i < r; i++) {
			for (int j = sz - 1; j < c; j++) {
				if (!dp[sz - 2][i - 1][j - 1]) continue;
				if (!is_row_reversed(i - sz + 1, i, j - sz + 1, j)) continue;
				if (!is_col_reversed(j - sz + 1, j, i - sz + 1, i)) continue;
				dp[sz][i][j] = true;
				ans = max(ans, sz);
			}
		}
	}

	cout << ans << '\n';
	return 0;
}