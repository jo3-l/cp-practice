#include <bits/stdc++.h>

using namespace std;

int solve(vector<int> &nums) {
	deque<int> dq;
	for (int j = 0; j < nums.size(); j++) {
		while (!dq.empty() && nums[dq.back()] - dq.back() < nums[j] - j) dq.pop_back();
		dq.push_back(j);
	}
	int ans = INT_MIN;
	for (int i = 0; i < (int)nums.size() - 1; i++) {
		while (!dq.empty() && dq.front() <= i) dq.pop_front();
		ans = max(ans, nums[dq.front()] - dq.front() + nums[i] + i);
	}
	return ans;
}