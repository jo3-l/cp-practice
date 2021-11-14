#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> solve(vector<vector<int>> &matrix, int k) {
	if (matrix.empty()) return {};
	int r = matrix.size(), c = matrix[0].size();
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (i > 0) matrix[i][j] += matrix[i - 1][j];
			if (j > 0) matrix[i][j] += matrix[i][j - 1];
			if (i > 0 && j > 0) matrix[i][j] -= matrix[i - 1][j - 1];
		}
	}
	auto query = [&](int r0, int c0, int r1, int c1) {
		return matrix[r1][c1] - (r0 > 0 ? matrix[r0 - 1][c1] : 0) - (c0 > 0 ? matrix[r1][c0 - 1] : 0) +
		       (r0 > 0 && c0 > 0 ? matrix[r0 - 1][c0 - 1] : 0);
	};
	vector<vector<int>> ans(r, vector<int>(c));
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			ans[i][j] = query(max(i - k, 0), max(j - k, 0), min(i + k, r - 1), min(j + k, c - 1));
		}
	}
	return ans;
}