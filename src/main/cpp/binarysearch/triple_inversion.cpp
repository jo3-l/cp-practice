#include <bits/stdc++.h>

using namespace std;

vector<int> t[200'000];

vector<int> merge(vector<int> &a, vector<int> &b) {
	vector<int> out(a.size() + b.size());
	int i = 0, j = 0, k = 0;
	while (i < a.size() || j < b.size()) {
		bool choose_a = (j >= b.size()) || (i < a.size() && a[i] <= b[j]);
		out[k++] = choose_a ? a[i++] : b[j++];
	}
	return out;
}

int count_gt(vector<int> &xs, int x) { return xs.end() - upper_bound(xs.begin(), xs.end(), x); }

int solve(vector<int> &nums) {
	int n = nums.size();
	for (int i = 0; i < n; i++) t[i + n] = {nums[i]};
	for (int i = n - 1; i > 0; i--) t[i] = merge(t[i * 2], t[i * 2 + 1]);

	// count elements in [l, r) that are > x
	auto query = [&](int l, int r, int x) {
		l += n;
		r += n;
		int cnt = 0;
		for (; l < r; l /= 2, r /= 2) {
			if (l & 1) cnt += count_gt(t[l++], x);
			if (r & 1) cnt += count_gt(t[--r], x);
		}
		return cnt;
	};
	int ans = 0;
	for (int j = 1; j < nums.size(); j++) ans += query(0, j, nums[j] * 3);
	return ans;
}