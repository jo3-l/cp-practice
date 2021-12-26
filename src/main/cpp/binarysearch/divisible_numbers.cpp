#include <bits/stdc++.h>

using namespace std;

int solve(int n, int a, int b, int c) {
	int lo = 0, hi = numeric_limits<int>::max();
	auto get_pos = [&](int k) { return k / a + k / b + k / c; };
	while (lo <= hi) {
		int mid = lo + (hi - lo) / 2;
		int pos = get_pos(mid);
		if (pos > n) {
			hi = mid - 1;
		} else if (pos == n) {
			for (int v : {mid / a * a, mid / b * b, mid / c * c, mid / a + (mid % a != 0), mid / b + (mid % b != 0),
				      mid / c + (mid % c != 0)}) {
				if (get_pos(v) == n) return v;
			}
			assert(false);
		} else {
			lo = mid + 1;
		}
	}
	assert(false);
}