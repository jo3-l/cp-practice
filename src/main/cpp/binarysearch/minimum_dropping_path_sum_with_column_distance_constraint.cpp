#include <bits/stdc++.h>

using namespace std;

int solve(vector<vector<int>> &matrix) {
	int R = matrix.size(), C = matrix[0].size();
	vector<int> dp = matrix[0];
	vector<int> ndp(C);
	for (int i = 1; i < R; i++) {
		for (int j = 0; j < C; j++) {
			ndp[j] = min({j > 0 ? dp[j - 1] : INT_MAX, dp[j], j < C - 1 ? dp[j + 1] : INT_MAX}) + matrix[i][j];
		}
		swap(dp, ndp);
	}
	return *min_element(dp.begin(), dp.end());
}