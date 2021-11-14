#include <bits/stdc++.h>

using namespace std;

int st[100'000][18];

int query(int l, int r) {
	int d = r - l + 1;
	int k = 31 - __builtin_clz(d);
	return max(st[l][k], st[r - (1 << k) + 1][k]);
}

vector<int> solve(vector<int> &nums) {
	if (nums.empty()) return nums;
	for (int i = 0; i < nums.size(); i++) st[i][0] = nums[i];
	int max_k = 32 - __builtin_clz(nums.size() - 1);
	for (int k = 1; k <= max_k; k++) {
		for (int i = 0; i + (1 << k) <= nums.size(); i++) {
			st[i][k] = max(st[i][k - 1], st[i + (1 << (k - 1))][k - 1]);
		}
	}
	for (int i = 0; i < nums.size(); i++) {
		if (i < nums.size() - 1) {
			// binary search for first idx j in (i, |nums|) where max(nums[i+1..j]) > nums[i]
			int lo = i + 1, hi = nums.size() - 1;
			while (lo < hi) {
				int mid = (lo + hi) >> 1;
				if (query(i + 1, mid) > nums[i]) hi = mid;
				else lo = mid + 1;
			}
			int v = query(i + 1, lo);
			if (v > nums[i]) {
				nums[i] = v;
				continue;
			}
		}
		if (i > 0) {
			// similar, but for the subarray preceding i
			int lo = 0, hi = i - 1;
			while (lo < hi) {
				int mid = (lo + hi) >> 1;
				if (query(0, mid) > nums[i]) hi = mid;
				else lo = mid + 1;
			}
			int v = query(0, lo);
			if (v > nums[i]) {
				nums[i] = v;
				continue;
			}
		}
		nums[i] = -1;
	}
	return nums;
}