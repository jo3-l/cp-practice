#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 30'000, MK = 501;
int dp[MN][MK];
int pfs[MN];

int query(int i, int j) { return pfs[j] - (i > 0 ? pfs[i - 1] : 0); }

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int t;
	cin >> t;
	while (t--) {
		int n, k, w;
		cin >> n >> k >> w;
		for (int i = 0; i < n; i++) {
			cin >> pfs[i];
			if (i > 0) pfs[i] += pfs[i - 1];
		}

		int ans = 0;
		memset(dp, 0, sizeof(dp));
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				int knock = min(w, i + 1);
				dp[i][j] =
				    max(query(i - knock + 1, i) + (i >= knock ? dp[i - knock][j - 1] : 0), (i > 0 ? dp[i - 1][j] : 0));
				ans = max(ans, dp[i][j]);
			}
		}

		cout << ans << '\n';
	}

	return 0;
}