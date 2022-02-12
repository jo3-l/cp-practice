#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 18;
int path_len[MN][MN]; // -1 if not set
int dp[1 << MN][MN];  // state: {vertices, end}, -1 if not possible

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	memset(dp, -1, sizeof(dp));
	memset(path_len, -1, sizeof(path_len));

	int ans = 0;
	int n, m;
	cin >> n >> m;
	while (m--) {
		int from, to, len;
		cin >> from >> to >> len;
		path_len[from][to] = len;
		dp[(1 << from) | (1 << to)][to] = len;
		if (from == 0 && to == n - 1) ans = max(ans, len);
	}

	for (int msk = 0; msk < (1 << n); msk++) {
		if (__builtin_popcount(msk) <= 2 || !(msk & 1)) continue;
		for (int last = 1; last < n; last++) {
			if (!(msk >> last & 1)) continue;
			int prev_msk = msk ^ (1 << last);
			for (int second_last = 1; second_last < n; second_last++) {
				if (!(prev_msk >> second_last & 1)) continue;
				if (path_len[second_last][last] == -1) continue;
				if (dp[prev_msk][second_last] == -1) continue;
				dp[msk][last] = max(dp[msk][last], dp[prev_msk][second_last] + path_len[second_last][last]);
			}

			if (last == n - 1) ans = max(ans, dp[msk][last]);
		}
	}

	cout << ans << '\n';
	return 0;
}