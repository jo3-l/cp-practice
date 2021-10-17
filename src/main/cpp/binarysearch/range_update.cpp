#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 10'000;
int pds[MN];

vector<int> solve(vector<int>& nums, vector<vector<int>>& ops) {
	if (nums.empty()) return nums;
	memset(pds, 0, sizeof(pds));
	for (int i = 1; i < nums.size(); i++) {
		pds[i] = nums[i] - nums[i - 1];
	}
	for (auto& op : ops) {
		pds[op[0]] += op[2];
		if (op[1] < nums.size()) pds[op[1] + 1] -= op[2];
	}

	nums[0] += pds[0];
	for (int i = 1; i < nums.size(); i++) {
		nums[i] = nums[i - 1] + pds[i];
	}
	return nums;
}