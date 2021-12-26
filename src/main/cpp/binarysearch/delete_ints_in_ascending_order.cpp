#include <bits/stdc++.h>

using namespace std;

vector<int> solve(vector<int> &nums) {
	vector<int> deleted;
	// get the number of deleted indices < i
	int n = nums.size() + 1;
	vector<int> bit(n);
	auto mark = [&](int idx) {
		for (idx++; idx < n; idx += idx & -idx) bit[idx]++;
	};
	auto get_marked = [&](int idx) {
		int ans = 0;
		for (idx++; idx > 0; idx -= idx & -idx) ans += bit[idx];
		return ans;
	};
	unordered_map<int, int> idxs;
	for (int i = 0; i < nums.size(); i++) idxs[nums[i]] = i;
	sort(nums.begin(), nums.end());
	for (int n : nums) {
		int idx = idxs[n];
		deleted.push_back(idx - get_marked(idx));
		mark(idx);
	}
	return deleted;
}