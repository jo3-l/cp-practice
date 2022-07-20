#include <bits/stdc++.h>

using namespace std;

constexpr int INF = 0x3f3f3f3f;

vector<int> run_knapsack(vector<int>& packs, int n) {
	vector<vector<int>> dp(2, vector<int>(n + 1, INF));
	dp[0][0] = 0;
	for (int i = 0; i < packs.size(); i++) {
		auto &cur = dp[(i & 1) ^ 1], &prev = dp[i & 1];
		for (int k = 0; k <= n; k++) {
			cur[k] = min({prev[k], k >= packs[i] ? prev[k - packs[i]] + 1 : INF});
		}
	}
	return dp[packs.size() & 1];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int h;
	cin >> h;
	vector<int> hotdogs(h);
	for (int& x : hotdogs) cin >> x;

	int b;
	cin >> b;
	vector<int> buns(b);
	for (int& x : buns) cin >> x;

	int x = min(accumulate(hotdogs.begin(), hotdogs.end(), 0), accumulate(buns.begin(), buns.end(), 0));
	auto min_packs_for_hotdogs = run_knapsack(hotdogs, x);
	auto min_packs_for_buns = run_knapsack(buns, x);

	int ans = INF;
	for (int i = 1; i <= x; i++) ans = min(ans, min_packs_for_hotdogs[i] + min_packs_for_buns[i]);
	if (ans == INF)
		cout << "impossible\n";
	else
		cout << ans << '\n';
	return 0;
}