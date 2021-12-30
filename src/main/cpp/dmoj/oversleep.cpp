#include <bits/stdc++.h>

using namespace std;

const int dx[]{1, 0, -1, 0};
const int dy[]{0, 1, 0, -1};

char grid[1000][1000];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, m;
	cin >> n >> m;
	queue<pair<int, int>> q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> grid[i][j];
			if (grid[i][j] == 's') {
				grid[i][j] = 'X';
				q.push({i, j});
			}
		}
	}

	int dist = 1;
	while (!q.empty()) {
		int sz = q.size();
		while (sz--) {
			int i, j;
			tie(i, j) = q.front();
			q.pop();
			for (int d = 0; d < 4; d++) {
				int n_i = i + dy[d], n_j = j + dx[d];
				if (0 <= n_i && n_i < n && 0 <= n_j && n_j < m) {
					if (grid[n_i][n_j] == 'e') goto done;
					if (grid[n_i][n_j] == '.') {
						grid[n_i][n_j] = 'X';
						q.push({n_i, n_j});
					}
				}
			}
		}
		dist++;
	}

	cout << -1 << '\n';
	return 0;

done:
	cout << dist - 1 << '\n';
	return 0;
}