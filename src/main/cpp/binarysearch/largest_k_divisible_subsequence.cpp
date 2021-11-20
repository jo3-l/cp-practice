#include <bits/stdc++.h>

using namespace std;

int solve(vector<int> &nums, int k) {
	vector<int> dp(k);
	vector<int> ndp(k);
	for (int i = 0; i < nums.size(); i++) {
		int m = nums[i] % k;
		for (int nk = 0; nk < k; nk++) {
			// since I can't do math, and k is small :)
			int c;
			for (c = 0; c < k; c++) {
				if ((c + m) % k == nk) break;
			}

			int x = dp[c] + nums[i];
			ndp[nk] = dp[nk];
			if (x % k == nk) ndp[nk] = max(ndp[nk], x);
		}
		swap(dp, ndp);
	}
	return dp[0];
}