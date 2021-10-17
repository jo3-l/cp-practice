#include <bits/stdc++.h>

using namespace std;
using ll = long long;

constexpr int MN = 300, MK = 301;
ll dp[MN][MK];

constexpr int MOD = 1e9 + 7;

int solve(vector<int> &nums, int k) {
	if (k == 0) return 1;
	if (nums.empty()) return 0;
	memset(dp, 0, sizeof(dp));
	for (int i = 0; i < nums.size(); i++) {
		for (int j = 1; j <= k; j++) {
			if (i > 0) dp[i][j] = dp[i - 1][j];
			if (j >= nums[i]) {
				if (j == nums[i]) dp[i][j]++;
				if (i > 0) dp[i][j] += dp[i - 1][j - nums[i]];
			}
			dp[i][j] %= MOD;
		}
	}
	return dp[(int)nums.size() - 1][k] % MOD;
}