#include <bits/stdc++.h>

using namespace std;

// add on segment, query sum
class LazySegTree {
public:
	LazySegTree(vector<int> &data) : n(data.size()), tree(n * 4), lazy_add(n * 4) {
		assert(!data.empty());
		build(data, 1, 0, n - 1);
	}

	int query(int l, int r) { return query(1, l, r, 0, n - 1); }
	void update(int l, int r, int addend) { return update(1, l, r, 0, n - 1, addend); }

private:
	int n;
	vector<int> tree;
	vector<int> lazy_add;

	void build(vector<int> &data, int v, int l, int r) {
		if (l == r) {
			tree[v] = data[l];
		} else {
			int mid = (l + r) / 2;
			build(data, v * 2, l, mid);
			build(data, v * 2 + 1, mid + 1, r);
			tree[v] = tree[v * 2] + tree[v * 2 + 1];
		}
	}

	int query(int v, int q_l, int q_r, int t_l, int t_r) {
		if (q_l > q_r) return 0;
		if (q_l == t_l && t_r == q_r) return tree[v];
		int t_m = (t_l + t_r) / 2;
		push(v, t_m - t_l + 1, t_r - t_m);
		int left_ans = query(v * 2, q_l, min(q_r, t_m), t_l, t_m);
		int right_ans = query(v * 2 + 1, max(t_m + 1, q_l), q_r, t_m + 1, t_r);
		return left_ans + right_ans;
	}

	void update(int v, int upd_l, int upd_r, int t_l, int t_r, int addend) {
		if (upd_l > upd_r) return;
		if (upd_l == t_l && upd_r == t_r) {
			tree[v] += addend * (t_r - t_l + 1);
			lazy_add[v] += addend;
		} else {
			int t_m = (t_l + t_r) / 2;
			push(v, t_m - t_l + 1, t_r - t_m);
			update(v * 2, upd_l, min(t_m, upd_r), t_l, t_m, addend);
			update(v * 2 + 1, max(t_m + 1, upd_l), upd_r, t_m + 1, t_r, addend);
			tree[v] = tree[v * 2] + tree[v * 2 + 1];
		}
	}

	void push(int v, int left_sz, int right_sz) {
		lazy_add[v * 2] += lazy_add[v];
		tree[v * 2] += lazy_add[v] * left_sz;
		lazy_add[v * 2 + 1] += lazy_add[v];
		tree[v * 2 + 1] += lazy_add[v] * right_sz;
		lazy_add[v] = 0;
	}
};
