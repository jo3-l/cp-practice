#include <bits/stdc++.h>

using namespace std;

const int dx[]{1, -1, 0, 0};
const int dy[]{0, 0, 1, -1};

int solve(vector<vector<int>> &matrix) {
	deque<pair<int, int>> dq;
	int r = matrix.size(), c = matrix[0].size();
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (matrix[i][j] == 0) dq.push_back({i, j});
		}
	}
	if (dq.size() == r * c || dq.empty()) return -1;
	int dist = 1;
	int max_dist = 0;
	while (!dq.empty()) {
		int sz = dq.size();
		while (sz--) {
			auto [i, j] = dq.front();
			dq.pop_front();
			for (int d = 0; d < 4; d++) {
				int n_i = i + dy[d], n_j = j + dx[d];
				if (0 <= n_i && n_i < r && 0 <= n_j && n_j < c) {
					if (matrix[n_i][n_j] == 1) {
						max_dist = max(max_dist, dist);
					}
					if (matrix[n_i][n_j] != -1) {
						matrix[n_i][n_j] = -1;
						dq.push_back({n_i, n_j});
					}
				}
			}
		}
		dist++;
	}
	return max_dist;
}