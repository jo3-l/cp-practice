#include <bits/stdc++.h>

using namespace std;

constexpr int INF = 0x3f3f3f3f;

int solve(vector<int> &nums) {
	int neg_nums = 0;
	int even_idx = -1, odd_idx = INF;
	int ans = 0;
	for (int i = 0; i < nums.size(); i++) {
		neg_nums += nums[i] < 0;
		if (nums[i]) {
			if (neg_nums & 1) {
				ans = max(ans, i - odd_idx);
				odd_idx = min(odd_idx, i);
			} else {
				ans = max(ans, i - even_idx);
			}
		} else {
			neg_nums = 0;
			even_idx = i;
			odd_idx = INF;
		}
	}
	return ans;
}