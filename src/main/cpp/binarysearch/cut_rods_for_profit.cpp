#include <bits/stdc++.h>

using namespace std;

int solve(vector<int> &rod_lens, int profit_per_len, int cost_per_cut) {
	if (rod_lens.empty()) return 0;
	auto f = [&](int len) {
		int profit = 0;
		for (int rod : rod_lens) {
			if (rod == len) {
				profit += rod * profit_per_len;
			} else if (rod > len) {
				int pieces = rod / len, cuts_needed = pieces - (rod % len == 0);
				profit += max(pieces * len * profit_per_len - cuts_needed * cost_per_cut, 0);
			}
		}
		return profit;
	};
	int ans = 0;
	for (int len = 1, hi = *max_element(rod_lens.begin(), rod_lens.end()); len <= hi; len++) {
		ans = max(ans, f(len));
	}
	return ans;
}
