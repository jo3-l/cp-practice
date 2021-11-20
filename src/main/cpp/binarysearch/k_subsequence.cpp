#include <bits/stdc++.h>

using namespace std;

int aux[100'000];
int upd_idx[100'000];
int sorted[100'000];
int seg[100'000 * 2];

int solve(vector<int> &nums, int k) {
	iota(begin(aux), begin(aux) + nums.size(), 0);
	sort(begin(aux), begin(aux) + nums.size(), [&](int i, int j) { return nums[i] < nums[j]; });
	for (int i = 0; i < nums.size(); i++) upd_idx[aux[i]] = i;

	copy(nums.begin(), nums.end(), begin(sorted));
	sort(begin(sorted), begin(sorted) + nums.size());

	memset(seg, 0, sizeof(seg));
	auto upd = [&](int i, int val) {
		i += nums.size();
		seg[i] = val;
		for (; i > 1; i >>= 1) seg[i >> 1] = max(seg[i], seg[i ^ 1]);
	};

	// max on [l, r)
	auto query = [&](int l, int r) {
		l += nums.size(), r += nums.size();
		int ans = 0;
		for (; l < r; l >>= 1, r >>= 1) {
			if (l & 1) ans = max(ans, seg[l++]);
			if (r & 1) ans = max(ans, seg[--r]);
		}
		return ans;
	};

	int ans = 0;
	for (int i = 0; i < nums.size(); i++) {
		int l = lower_bound(begin(sorted), begin(sorted) + nums.size(), nums[i] - k) - begin(sorted);
		int r = upper_bound(begin(sorted), begin(sorted) + nums.size(), nums[i] + k) - begin(sorted);
		int q = max(query(l, r) + 1, 1);
		ans = max(ans, q);
		upd(upd_idx[i], q);
	}
	return ans;
}