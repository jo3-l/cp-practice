#include <bits/stdc++.h>

using namespace std;

unordered_map<int, int> mp;

int solve(int k, vector<int> &nums) {
	if (nums.empty()) return 0;

	int N = (int)nums.size();
	int lo = 0;
	int hi = 0;
	int ans = 0;
	mp[nums[0]]++;
	while (hi < N) {
		if (mp.size() > k) {
			if (lo < N && --mp[nums[lo]] == 0) mp.erase(nums[lo]);
			lo++;
			if (lo > hi) {
				++hi;
				if (hi < N) mp[nums[hi]]++;
			}
		} else {
			ans = max(ans, hi - lo + 1);
			++hi;
			if (hi < N) mp[nums[hi]]++;
		}
	}

	mp.clear();
	return ans;
}