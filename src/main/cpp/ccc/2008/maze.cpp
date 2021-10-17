#include <bits/stdc++.h>

using namespace std;

constexpr int MR = 20, MC = 20;
char grid[MR][MC];
bool vis[MR][MC];

vector<pair<int, int>> get_moves(char c) {
	if (c == '+') return {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	if (c == '-') return {{0, 1}, {0, -1}};
	return {{1, 0}, {-1, 0}};
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int t;
	cin >> t;
	while (t--) {
		int r, c;
		cin >> r >> c;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) cin >> grid[i][j];
		}
		if (r == 1 && c == 1) {
			cout << 1 << '\n';
		} else if (grid[r - 1][c - 1] == '*') {
			cout << -1 << '\n';
		} else {
			memset(vis, false, sizeof(vis));
			int used = 1;
			queue<pair<int, int>> q;
			q.push({0, 0});
			vis[0][0] = true;
			while (!q.empty()) {
				int sz = q.size();
				while (sz--) {
					int i, j;
					tie(i, j) = q.front();
					q.pop();
					for (pair<int, int> d : get_moves(grid[i][j])) {
						int ni = i + d.first, nj = j + d.second;
						if (ni == r - 1 && nj == c - 1) goto found;
						if (0 <= ni && ni < r && 0 <= nj && nj < c && !vis[ni][nj] && grid[i][j] != '*') {
							q.push({ni, nj});
							vis[ni][nj] = true;
						}
					}
				}
				used++;
			}

			cout << -1 << '\n';
			continue;
		found:
			cout << used + 1 << '\n';
		}
	}

	return 0;
}