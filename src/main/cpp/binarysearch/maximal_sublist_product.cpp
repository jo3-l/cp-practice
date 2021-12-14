#include <bits/stdc++.h>

using namespace std;

constexpr int INF = 0x3f3f3f3f;

int solve(vector<int> &nums) {
	int max_lt_0 = -INF;
	int min_gt_0 = 1;
	int ans = -INF;
	int prod = 1;
	for (int n : nums) {
		prod *= n;
		ans = max({ans, prod / min_gt_0, max_lt_0 == -INF ? -INF : prod / max_lt_0});
		if (prod == 0) {
			prod = 1;
			max_lt_0 = -INF;
			min_gt_0 = 1;
		}
		if (prod < 0) max_lt_0 = max(max_lt_0, prod);
		if (prod > 0) min_gt_0 = min(min_gt_0, prod);
	}
	return ans;
}