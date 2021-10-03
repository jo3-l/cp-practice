#include <bits/stdc++.h>

using namespace std;

const int MN = 250;
const int MM = 250;

bool island[MN][MM];

const int di[] = {1, -1, 0, 0};
const int dj[] = {0, 0, 1, -1};

int solve(vector<vector<int>> &matrix) {
	memset(island, false, sizeof(island));
	int R = matrix.size(), C = matrix[0].size();

	std::function<void(int, int)> go = [&](int i, int j) {
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d], nj = j + dj[d];
			if (0 <= ni && ni < R && 0 <= nj && nj < C && matrix[ni][nj] == 1 && !island[ni][nj]) {
				island[ni][nj] = true;
				go(ni, nj);
			}
		}
	};
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (matrix[i][j] == 1) {
				island[i][j] = true;
				go(i, j);
				goto after_loop;
			}
		}
	}

after_loop:
	queue<pair<int, int>> q;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (!island[i][j] && matrix[i][j] == 1) q.push({i, j});
		}
	}

	int depth = 0;
	while (!q.empty()) {
		int sz = q.size();
		while (sz--) {
			auto &[i, j] = q.front();
			q.pop();
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (0 <= ni && ni < R && 0 <= nj && nj < C) {
					if (island[ni][nj]) return depth;
					if (matrix[ni][nj] == 0) {
						q.push({ni, nj});
						matrix[ni][nj] = 1;
					}
				}
			}
		}
		depth++;
	}

	return -1;
}