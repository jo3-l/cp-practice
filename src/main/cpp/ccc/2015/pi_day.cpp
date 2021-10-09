#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 251;

// dp(i, j, k) = number of ways to distribute i pieces of pie between the first j people if the
// j-1th person got k pieces of pie
int dp[MN][MN][MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, k;
	cin >> n >> k;

	int ans = 0;
	for (int pie = 1; pie <= n; pie++) {
		for (int person = 1; person <= k; person++) {
			for (int ate = 1; ate <= pie; ate++) {
				if (person == 1) {
					dp[pie][person][ate] = pie == ate;
				} else {
					for (int last_ate = 1; last_ate <= ate; last_ate++) {
						dp[pie][person][ate] += dp[pie - ate][person - 1][last_ate];
					}
				}

				if (pie == n && person == k) ans += dp[pie][person][ate];
			}
		}
	}

	cout << ans << '\n';
	return 0;
}