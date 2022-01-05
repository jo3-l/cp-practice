#include <bits/stdc++.h>

using namespace std;

int avgs[1'000'005];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, q;
	cin >> n >> q;
	for (int i = 0; i < n; i++) {
		cin >> avgs[i];
		if (i > 0) avgs[i] += avgs[i - 1];
	}

	while (q--) {
		int l, r;
		cin >> l >> r;
		l--, r--;
		int t = avgs[r] - (l > 0 ? avgs[l - 1] : 0);
		cout << t / (r - l + 1) << '\n';
	}
	return 0;
}