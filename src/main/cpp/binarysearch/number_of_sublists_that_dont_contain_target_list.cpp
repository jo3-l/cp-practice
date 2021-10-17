#include <bits/stdc++.h>

using namespace std;
using ll = long long;

constexpr int MOD = 1e9 + 7;

unordered_map<int, int> mp;

int solve(vector<int> &nums, vector<int> &target) {
	mp.clear();
	unordered_set<int> s(target.begin(), target.end());
	ll contained = 0;
	int j = 0;
	int ans = 0;
	for (int i = 0; i < nums.size(); i++) {
		if (++mp[nums[i]] == 1 && s.count(nums[i])) contained++;
		if (contained < s.size()) {
			ans += i - j + 1;
			ans %= MOD;
		} else {
			while (contained >= s.size() && j <= i) {
				if (--mp[nums[j]] == 0 && s.count(nums[j])) {
					mp.erase(nums[j]);
					if (--contained < s.size()) {
						ans += i - j;
						ans %= MOD;
					}
				}
				j++;
			}
		}
	}
	return ans % MOD;
}