#include <bits/stdc++.h>

using namespace std;

constexpr int INF = 0x3f3f3f3f;

int solve(vector<int> &&nums, int n) {
	sort(nums.begin(), nums.end());
	int ans = INF;
	for (int j = 1; j < nums.size() - 1; j++) {
		int i = 0, k = nums.size() - 1;
		while (i < j && j < k) {
			int s = nums[i] + nums[j] + nums[k];
			ans = min(ans, abs(s - n));
			if (s < n) i++;
			else k--;
		}
	}
	return ans;
}
