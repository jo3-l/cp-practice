#include <bits/stdc++.h>

using namespace std;

int prices[1000];
int pages[1000];
int dps[2][100'000];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, x;
	cin >> n >> x;
	for (int i = 0; i < n; i++) cin >> prices[i];
	for (int i = 0; i < n; i++) cin >> pages[i];
	int ans = 0;
	for (int i = 0; i < n; i++) {
		auto &dp = dps[i & 1];
		auto &ndp = dps[(i & 1) ^ 1];
		for (int k = 0; k <= x; k++) {
			ndp[k] = dp[k];
			if (k >= prices[i]) ndp[k] = max(ndp[k], dp[k - prices[i]] + pages[i]);
			ans = max(ans, ndp[k]);
		}
	}
	cout << ans << '\n';
	return 0;
}