#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 400;
int pfs[MN];
int dp[MN][MN]; // dp(i, j) = can we combine all the riceballs from i to j?

// sum on [i, j]
int query(int i, int j) { return pfs[j] - (i > 0 ? pfs[i - 1] : 0); }

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, ans = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		dp[i][i] = true;
		cin >> pfs[i];
		ans = max(ans, pfs[i]);
		if (i > 0) pfs[i] += pfs[i - 1];
	}

	for (int i = n - 1; i >= 0; i--) {
		for (int j = i + 1; j < n; j++) {
			// aaaaaa bbbbbbbbb ccccccc
			// ^^^^^^           ^^^^^^^
			// i    l           r     j
			for (int l = i, r = j; l < r;) {
				bool mid_possible = l == r - 1 || dp[l + 1][r - 1], left_possible = dp[i][l], right_possible = dp[r][j];
				int left_sum = query(i, l), right_sum = query(r, j);
				if (!mid_possible || !left_possible || !right_possible || left_sum != right_sum) {
					if (left_sum >= right_sum) r--;
					if (left_sum <= right_sum) l++;
					continue;
				}

				dp[i][j] = true;
				ans = max(ans, query(i, j));
				break;
			}
		}
	}

	cout << ans << '\n';
	return 0;
}