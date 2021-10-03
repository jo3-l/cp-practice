#include <bits/stdc++.h>

using namespace std;

const int MN = 1e5;

int tree[MN << 1];
int len = 0;

// query on [i, j)
int query(int i, int j) {
	int ans = 0;
	for (i += len, j += len; i < j; i >>= 1, j >>= 1) {
		if (i & 1) ans ^= tree[i++];
		if (j & 1) ans ^= tree[--j];
	}
	return ans;
}

void build(vector<int> &nums) {
	for (int i = 0; i < nums.size(); i++)
		tree[i + len] = nums[i];
	for (int i = len - 1; i > 0; i--)
		tree[i] = tree[i << 1] ^ tree[i << 1 | 1];
}

vector<int> solve(vector<int> &nums, vector<vector<int>> &queries) {
	memset(tree, 0, sizeof(tree));
	len = (int)nums.size();
	build(nums);

	vector<int> ans(queries.size(), 0);
	for (int i = 0; i < queries.size(); i++) {
		ans[i] = query(queries[i][0], queries[i][1] + 1);
	}
	return ans;
};
