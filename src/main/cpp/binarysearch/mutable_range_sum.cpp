#include <bits/stdc++.h>

using namespace std;

class MutableRangeSum {
      public:
	MutableRangeSum(vector<int> &nums) : len(nums.size()) {
		data.resize(len << 1);
		build(nums);
	}

	int total(int i, int j) {
		int ans = 0;
		for (i += len, j += len; i < j; i >>= 1, j >>= 1) {
			if (i & 1) ans += data[i++];
			if (j & 1) ans += data[--j];
		}
		return ans;
	}

	void update(int i, int v) {
		data[i += len] = v;
		for (; i > 1; i >>= 1)
			data[i >> 1] = data[i] + data[i ^ 1];
	}

      private:
	vector<int> data;
	int len;

	void build(vector<int> &nums) {
		for (int i = 0; i < len; i++)
			data[i + len] = nums[i];
		for (int i = len - 1; i > 0; i--)
			data[i] = data[i << 1] + data[i << 1 | 1];
	}
};