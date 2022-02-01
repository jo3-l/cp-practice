#include <bits/stdc++.h>

using namespace std;

double dps[2][1 << 20];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	dps[0][0] = 1;
	for (int i = 0; i < n; i++) {
		auto &dp = dps[i & 1];
		auto &ndp = dps[(i & 1) ^ 1];
		for (int j = 0; j < n; j++) {
			int p;
			cin >> p;
			double prb = p / 100.;
			for (int msk = 0; msk < (1 << n); msk++) {
				ndp[msk | (1 << j)] = max(ndp[msk | (1 << j)], dp[msk] * prb);
			}
		}
	}

	cout << setprecision(10) << fixed << (dps[n & 1][(1 << n) - 1] * 100) << '\n';
	return 0;
}