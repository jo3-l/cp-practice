#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 100;
int measurements[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) cin >> measurements[i];
	sort(begin(measurements), begin(measurements) + n);
	for (int lo = (n - 1) >> 1, hi = lo + 1; lo >= 0; lo--, hi++) {
		if (lo < hi - 1) cout << ' ';
		cout << measurements[lo];
		if (hi < n) cout << ' ' << measurements[hi];
	}

	return 0;
}