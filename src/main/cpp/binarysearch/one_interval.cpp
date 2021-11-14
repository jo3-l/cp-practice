#include <bits/stdc++.h>

using namespace std;

int solve(vector<vector<int>> &intervals) {
	sort(begin(intervals), end(intervals), [](auto &a, auto &b) { return a[0] < b[0]; });
	int min_end = INT_MAX, max_start = INT_MIN;
	int disjoint_intervals = 0;
	int i = 0;
	while (i < intervals.size()) {
		auto &interval = intervals[i++];
		while (i < intervals.size() && intervals[i][0] <= interval[1]) interval[1] = max(interval[1], intervals[i++][1]);
		min_end = min(min_end, interval[1]);
		max_start = max(max_start, interval[0]);
		disjoint_intervals++;
	}
	if (disjoint_intervals < 2) return 0;
	return max_start - min_end;
}