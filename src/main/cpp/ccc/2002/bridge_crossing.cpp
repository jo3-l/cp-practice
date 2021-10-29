#include <bits/stdc++.h>

using namespace std;

int dp[105], parent[105];
pair<string, int> people[105];

constexpr int INF = 0x3f3f3f3f;

int main() {
	parent[0] = -1;
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	int m, q;
	cin >> m >> q;
	for (int i = 0; i < q; i++) cin >> people[i].first >> people[i].second;
	for (int i = 1; i <= q; i++) {
		dp[i] = INF;
		int max_time = -INF;
		for (int q_s = 1; q_s <= min(i, m); q_s++) {
			max_time = max(max_time, people[i - q_s].second);
			int cand = dp[i - q_s] + max_time;
			if (cand < dp[i]) {
				dp[i] = cand;
				parent[i] = i - q_s;
			}
		}
	}

	vector<string> ans;
	cout << "Total Time: " << dp[q] << '\n';
	int lo = parent[q], hi = q;
	while (lo != -1) {
		string crossed;
		for (int i = lo; i < hi; i++) {
			if (i > lo) crossed += ' ';
			crossed += people[i].first;
		}
		ans.push_back(crossed);
		hi = lo;
		lo = parent[hi];
	}
	for (int i = ans.size() - 1; i >= 0; i--) cout << ans[i] << '\n';
	return 0;
}
