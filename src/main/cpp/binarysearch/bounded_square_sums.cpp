#include <bits/stdc++.h>

using namespace std;

int solve(vector<int> &a, vector<int> &b, int lower, int upper) {
	transform(b.begin(), b.end(), b.begin(), [](int v) { return v * v; });
	sort(b.begin(), b.end());
	int n = 0;
	for (int v : a) {
		v *= v;
		int lp = lower_bound(b.begin(), b.end(), lower - v) - b.begin();
		int up = upper_bound(b.begin(), b.end(), upper - v) - b.begin();
		n += max(up - lp, 0);
	}
	return n;
}