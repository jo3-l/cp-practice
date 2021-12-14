#include <bits/stdc++.h>

using namespace std;

constexpr int INF = 0x3f3f3f3f;

int solve(vector<int> &nums) {
	if (nums.empty()) return 0;
	vector<int> max_pref(nums.size());
	max_pref[0] = nums[0];
	for (int i = 1; i < nums.size(); i++) max_pref[i] = max(max_pref[i - 1], nums[i]);

	vector<int> min_suff(nums.size());
	min_suff[nums.size() - 1] = nums.back();
	for (int i = (int)nums.size() - 2; i >= 0; i--) min_suff[i] = min(min_suff[i + 1], nums[i]);

	int ans = 0;
	for (int i = 0; i < nums.size(); i++) {
		int max_p = i > 0 ? max_pref[i - 1] : -INF;
		int min_s = i < nums.size() - 1 ? min_suff[i + 1] : INF;
		if (max_p < nums[i] && nums[i] < min_s) ans++;
	}
	return ans;
}