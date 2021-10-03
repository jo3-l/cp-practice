#include <bits/stdc++.h>

using namespace std;

const int MN = 1000;
bool dp[MN][MN];
bool seen[MN];

int solve(string s) {
	if (s.empty()) return 0;
	memset(dp, 0, sizeof(dp));
	memset(seen, false, sizeof(seen));
	for (int i = 0; i < s.size(); i++) {
		for (int len = 0; len < s.size(); len++) {
			int l = i - len, r = i + len;
			if (l < 0 || r >= s.size() || s[l] != s[r]) break;
			dp[l][r] = true;
		}
		for (int l = i, r = i + 1; l >= 0 && r < s.size(); r++, l--) {
			if (s[l] != s[r]) break;
			dp[l][r] = true;
		};
	};
	if (dp[0][s.length() - 1]) return 1;
	queue<int> q;
	for (int i = s.length() - 2; i >= 0; i--) {
		if (dp[0][i]) {
			q.push(i + 1);
		}
	}
	seen[0] = true;
	int cnt = 1;
	while (!q.empty()) {
		int sz = q.size();
		while (sz--) {
			int k = q.front();
			q.pop();
			if (dp[k][s.length() - 1]) return cnt + 1;
			for (int i = s.length() - 2; i >= k; i--) {
				if (!seen[i + 1] && dp[k][i]) {
					q.push(i + 1);
					seen[k] = true;
				}
			}
		}
		cnt++;
	}
	return -1;
}