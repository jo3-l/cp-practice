#include <bits/stdc++.h>

using namespace std;

constexpr int INF = numeric_limits<int>::max();

int solve(vector<int> &nums) {
	vector<int> min_suff(nums.size());
	partial_sum(nums.rbegin(), nums.rend(), min_suff.rbegin(), [](int a, int b) { return min(a, b); });
	int cnt = 0, cur_max = -INF;
	for (int i = 0; i < nums.size(); i++) {
		cur_max = max(cur_max, nums[i]);
		cnt += i == nums.size() - 1 || cur_max <= min_suff[i + 1];
	}
	return cnt;
}