#include <bits/stdc++.h>

using namespace std;

constexpr int INF = 0x3f3f3f3f;

int dp[501][11];

int solve(vector<int> &jobs, int k) {
	// partition jobs into k sublists minimizing the total minimums
	memset(dp, 0x3f, sizeof(dp));
	dp[0][0] = 0;
	for (int i = 1; i <= jobs.size(); i++) {
		for (int j = 1; j <= min(k, i); j++) {
			dp[i][j] = INF;
			int max_diff = 0;
			for (int z = i; z > j - 1; z--) {
				max_diff = max(max_diff, jobs[z - 1]);
				dp[i][j] = min(dp[i][j], dp[z - 1][j - 1] + max_diff);
			}
		}
	}
	return dp[jobs.size()][k];
}