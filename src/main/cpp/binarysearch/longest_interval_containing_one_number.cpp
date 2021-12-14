#include <bits/stdc++.h>

using namespace std;

int solve(vector<int> &nums) {
	if (nums.empty()) return 0;
	nums.push_back(0);
	sort(nums.begin(), nums.end());
	nums.push_back(100'001);
	int ans = 0;
	for (int i = 2; i < nums.size(); i++) {
		ans = max(ans, nums[i] - nums[i - 2] - 1);
	}
	return ans;
}