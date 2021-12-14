#include <bits/stdc++.h>

using namespace std;

int prev_pos[1000];

int solve(vector<int> &nums) {
	auto f = [&](int buses) {
		memset(prev_pos, -1, sizeof(prev_pos));
		for (int i = 0; i < nums.size(); i++) {
			int j;
			for (j = 0; j < buses; j++) {
				if (prev_pos[j] < nums[i]) {
					prev_pos[j] = nums[i];
					break;
				}
			}
			if (j >= buses) return false;
		}
		return true;
	};
	int lo = 0, hi = nums.size();
	while (lo < hi) {
		int mid = (lo + hi) >> 1;
		if (f(mid)) hi = mid;
		else lo = mid + 1;
	}
	return lo;
}