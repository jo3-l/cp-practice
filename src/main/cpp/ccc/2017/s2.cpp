#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	vector<int> measurements(n);
	for (auto& m : measurements) cin >> m;
	sort(measurements.begin(), measurements.end());

	for (int lo = (n - 1) >> 1, hi = lo + 1; lo >= 0; lo--, hi++) {
		if (lo < hi - 1) cout << ' ';
		cout << measurements[lo];
		if (hi < n) cout << ' ' << measurements[hi];
	}
}