#include <bits/stdc++.h>
#include <cstdio>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, ans = 0;
	cin >> n;

	vector<int> pref_sum(n);
	auto query_sum = [&](int i, int j) { // [i, j]
		return pref_sum[j] - (i > 0 ? pref_sum[i - 1] : 0);
	};

	for (int i = 0; i < n; i++) {
		int riceball_size;
		cin >> riceball_size;
		ans = max(ans, riceball_size);
		pref_sum[i] = riceball_size + (i > 0 ? pref_sum[i - 1] : 0);
	}

	vector<vector<int>> dp(n, vector<int>(n)); // dp[i, j] = can we combine all the riceballs from i to j?
	for (int i = 0; i < n; i++) dp[i][i] = true;

	for (int i = n - 1; i >= 0; i--) {
		for (int j = i + 1; j < n; j++) {
			// aaaaaa bbbbbbbbb ccccccc
			// ^^^^^^           ^^^^^^^
			// i    l           r     j
			for (int l = i, r = j; l < r;) {
				bool mid_possible = l == r - 1 || dp[l + 1][r - 1], left_possible = dp[i][l], right_possible = dp[r][j];
				int left_sum = query_sum(i, l), right_sum = query_sum(r, j);
				if (!mid_possible || !left_possible || !right_possible || left_sum != right_sum) {
					if (left_sum >= right_sum) r--;
					if (left_sum <= right_sum) l++;
					continue;
				}

				dp[i][j] = true;
				ans = max(ans, query_sum(i, j));
				break;
			}
		}
	}

	cout << ans << '\n';
}