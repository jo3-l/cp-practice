#include <bits/stdc++.h>

using namespace std;

bool solve(vector<int> &nums, int k) {
	vector<int> mod(k, -1);
	int sum_mod = 0;
	for (int i = 0; i < nums.size(); i++) {
		sum_mod = (sum_mod + nums[i]) % k;
		if (sum_mod == 0 && i >= 1) return true;
		if (mod[sum_mod] == -1) mod[sum_mod] = i;
		else if (i - mod[sum_mod] >= 2) return true;
	}
	return false;
}