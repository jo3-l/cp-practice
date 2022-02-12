#include <bits/stdc++.h>

using namespace std;

vector<int> solve(vector<int> &nums) {
	unordered_map<int, vector<int>> seen_at;
	for (int i = 0; i < nums.size(); i++) seen_at[nums[i]].push_back(i);
	vector<int> ans(nums.size());
	for (auto &[num, indices] : seen_at) {
		int i0 = indices[0];

		int larger = 0, larger_cnt = 0;
		int smaller = 0, smaller_cnt = 0;
		for (int i = 1; i < indices.size(); i++) larger += indices[i], larger_cnt++;

		ans[i0] = larger - i0 * larger_cnt;
		for (int i = 1; i < indices.size(); i++) {
			smaller += indices[i - 1], smaller_cnt++;
			larger -= indices[i], larger_cnt--;
			ans[indices[i]] = (larger - indices[i] * larger_cnt) + (indices[i] * smaller_cnt - smaller);
		}
	}

	return ans;
}