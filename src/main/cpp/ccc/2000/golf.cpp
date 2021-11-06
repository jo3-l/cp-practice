#include <bits/stdc++.h>

using namespace std;

int dp[33][5281];

constexpr int INF = 0x3f3f3f3f;

int main() {
	memset(dp, 0x3f, sizeof(dp));
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int dist;
	cin >> dist;
	dp[0][0] = 0;
	int club_cnt;
	cin >> club_cnt;
	int ans = INF;
	for (int i = 1; i <= club_cnt; i++) {
		int club;
		cin >> club;
		for (int j = 0; j <= dist; j++) {
			dp[i][j] = dp[i - 1][j];
			if (j >= club && dp[i][j - club] != INF) dp[i][j] = min(dp[i][j], dp[i][j - club] + 1);
		}
		ans = min(ans, dp[i][dist]);
	}

	if (ans == INF) cout << "Roberta acknowledges defeat." << '\n';
	else cout << "Roberta wins in " << ans << " strokes." << '\n';
	return 0;
}