#include <bits/stdc++.h>

using namespace std;

int cnt[2];

int solve(vector<int> &nums, int k) {
	memset(cnt, 0, sizeof(cnt));
	// longest sublist with at most k zeros
	int i = 0;
	int ans = 0;
	for (int j = 0; j < nums.size(); j++) {
		cnt[nums[j]]++;
		if (cnt[0] <= k) {
			ans = max(ans, cnt[0] + cnt[1]);
		} else {
			while (cnt[0] > k && i <= j) {
				cnt[nums[i]]--;
				i++;
			}
		}
	}
	return ans;
}