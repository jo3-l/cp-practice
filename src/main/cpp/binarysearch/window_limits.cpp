#include <bits/stdc++.h>

using namespace std;

bool solve(vector<int> &nums, int window, int limit) {
	deque<int> min_dq, max_dq;
	// [lo, hi)
	for (int lo = 0, hi = window; hi <= nums.size(); lo++, hi++) {
		auto push_min = [&](int idx) {
			while (!min_dq.empty() && nums[min_dq.back()] > nums[idx]) min_dq.pop_back();
			min_dq.push_back(idx);
		};
		auto push_max = [&](int idx) {
			while (!max_dq.empty() && nums[max_dq.back()] < nums[idx]) max_dq.pop_back();
			max_dq.push_back(idx);
		};

		if (lo > 0) {
			push_min(hi - 1);
			push_max(hi - 1);
		} else {
			for (int i = 0; i < hi; i++) {
				push_min(i);
				push_max(i);
			}
		}

		while (!min_dq.empty() && min_dq.front() < lo) min_dq.pop_front();
		int min_v = nums[min_dq.front()];
		while (!max_dq.empty() && max_dq.front() < lo) max_dq.pop_front();
		int max_v = nums[max_dq.front()];
		if (abs(max_v - min_v) > limit) return false;
	}
	return true;
}