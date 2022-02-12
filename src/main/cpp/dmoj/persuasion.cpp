#include <bits/stdc++.h>

using namespace std;
using ll = long long;

constexpr ll INF = 0x3f3f3f3f3f3f3f3f;

constexpr int MN = 19;
int multipliers[MN];
int pies[MN];
ll dp[1 << MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) cin >> multipliers[i];
	for (int i = 0; i < n; i++) cin >> pies[i];
	for (int msk = 1; msk < (1 << n); msk++) {
		dp[msk] = -INF;

		int round = __builtin_popcount(msk);
		for (int i = 0; i < n; i++) {
			if (msk >> i & 1) {
				ll prev = dp[msk ^ (1 << i)];
				int j = (i - round + 1 + n) % n;
				dp[msk] = max(dp[msk], prev + multipliers[i] * pies[j]);
			}
		}
	}

	cout << dp[(1 << n) - 1] << '\n';
	return 0;
}