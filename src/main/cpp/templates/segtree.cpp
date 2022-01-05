#include <bits/stdc++.h>

using namespace std;

class SegTree {
public:
	SegTree(vector<int> xs) : n(xs.size()), tree(n * 2) {
		for (int i = 0; i < xs.size(); i++) tree[i + n] = xs[i];
		for (int i = n - 1; i > 0; i--) tree[i] = tree[i * 2] + tree[i * 2 + 1];
	}

	void modify(int i, int val) {
		tree[i += n] = val;
		for (; i > 1; i /= 2) tree[i / 2] = tree[i] + tree[i ^ 1];
	}

	// [i, j)
	int query(int i, int j) {
		int left_ans = 0, right_ans = 0;
		for (i += n, j += n; i < j; i /= 2, j /= 2) {
			if (i & 1) left_ans += tree[i++];
			if (j & 1) right_ans += tree[--j];
		}
		return left_ans + right_ans;
	}

private:
	vector<int> tree;
	int n;
};