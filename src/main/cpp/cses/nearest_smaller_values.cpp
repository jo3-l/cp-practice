#include <bits/stdc++.h>

using namespace std;

int t[200'000][18];

// min on [i, j]
int query(int i, int j) {
	int k = 31 - __builtin_clz(j - i + 1);
	return min(t[i][k], t[j - (1 << k) + 1][k]);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) cin >> t[i][0];
	for (int k = 1; k <= 32 - __builtin_clz(n - 1); k++) {
		for (int i = 0; i + (1 << k) <= n; i++) t[i][k] = min(t[i][k - 1], t[i + (1 << (k - 1))][k - 1]);
	}

	for (int i = 0; i < n; i++) {
		if (i == 0) {
			cout << '0';
			continue;
		}
		cout << ' ';
		int lo = 0, hi = i - 1;
		while (lo < hi) {
			int mid = (lo + hi + 1) / 2;
			if (query(mid, i - 1) < t[i][0]) lo = mid;
			else hi = mid - 1;
		}
		cout << (query(lo, i - 1) < t[i][0] ? lo + 1 : 0);
	}
	cout << '\n';
	return 0;
}