#include <bits/stdc++.h>

using namespace std;

int par[250 * 250];
int sz[250 * 250];
bool vis[250][250];
unordered_set<int> seen;

const int di[] = {1, -1, 0, 0};
const int dj[] = {0, 0, 1, -1};

int find_set(int p) {
	if (par[p] == p) return p;
	return par[p] = find_set(par[p]);
}

int solve(vector<vector<int>> &matrix) {
	memset(vis, false, sizeof(vis));
	int R = matrix.size(), C = matrix[0].size();
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			int p = i * C + j;
			sz[p] = 1;
			par[p] = p;
		}
	}

	int max_sz = 1;
	function<void(int, int)> dfs = [&](int i, int j) {
		vis[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d], nj = j + dj[d];
			if (0 <= ni && ni < R && 0 <= nj && nj < C && matrix[ni][nj] &&
			    !vis[ni][nj]) {
				// unite (i, j) and (ni, nj)
				int a = find_set(i * C + j), b = find_set(ni * C + nj);
				if (sz[a] < sz[b]) swap(a, b);
				par[a] = b;
				sz[b] += sz[a];
				max_sz = max(max_sz, sz[b]);
				dfs(ni, nj);
			}
		}
	};

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (!vis[i][j] && matrix[i][j]) dfs(i, j);
		}
	}

	int ans = max_sz;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			seen.clear();
			if (!matrix[i][j]) {
				int c = 1;
				for (int d = 0; d < 4; d++) {
					int ni = i + di[d], nj = j + dj[d];
					if (0 <= ni && ni < R && 0 <= nj && nj < C &&
					    matrix[ni][nj]) {
						int s = find_set(ni * C + nj);
						if (!seen.count(s)) {
							c += sz[s];
							seen.insert(s);
						}
					}
				}
				ans = max(ans, c);
			}
		}
	}
	return ans;
}
