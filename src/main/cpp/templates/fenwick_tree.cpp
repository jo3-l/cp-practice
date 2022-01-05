#include <bits/stdc++.h>

using namespace std;

class FenwickTree {
public:
	FenwickTree(vector<int> xs) : n(xs.size() + 1), bit(n, 0) {
		for (int i = 0; i < xs.size(); i++) add(i, xs[i]);
	}

	void add(int i, int inc) {
		for (++i; i < n; i += i & -i) bit[i] += inc;
	}

	int query(int i) {
		int ans = 0;
		for (++i; i > 0; i -= i & -i) ans += bit[i];
		return ans;
	}

	int query(int i, int j) { return query(j) - query(i - 1); }

private:
	vector<int> bit;
	int n;
};
