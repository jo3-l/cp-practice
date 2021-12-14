#include <bits/stdc++.h>

using namespace std;

int solve(vector<int> &nums, int k) {
	if (nums.empty()) return 0;
	sort(nums.begin(), nums.end());
	int lo = 0, hi = nums.size() - 1;
	int cnt = 0;
	while (lo <= hi) {
		if (nums[lo] + nums[hi] > k) {
			hi--;
		} else {
			cnt += 1 << (hi - lo);
			lo++;
		}
	}
	return cnt;
}