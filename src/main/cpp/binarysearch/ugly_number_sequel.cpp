#include <bits/stdc++.h>

using namespace std;

const int factors[]{2, 3, 5};

int solve(int n) {
	vector<int> terms{1, 2, 3, 4, 5, 6, 8, 9, 10};
	int k = n - terms.size() + 1;
	if (k <= 0) return terms[n];
	while (k--) {
		int nxt = INT_MAX;
		for (int f : factors) {
			int prev = *upper_bound(terms.begin(), terms.end(), terms.back() / f);
			nxt = min(nxt, f * prev);
		}
		terms.push_back(nxt);
	}
	return terms.back();
}