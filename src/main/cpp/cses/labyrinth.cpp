#include <bits/stdc++.h>

using namespace std;

char grid[1000][1000];
int prev_dir[1000][1000];

const int dx[]{0, -1, 1, 0};
const int dy[]{-1, 0, 0, 1};
const char dir_names[]{'U', 'L', 'R', 'D'};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, m;
	cin >> n >> m;
	pair<int, int> a, b;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> grid[i][j];
			if (grid[i][j] == 'A') a = {i, j};
			else if (grid[i][j] == 'B') b = {i, j};
		}
	}

	deque<pair<int, int>> dq;
	dq.push_back(a);
	int step = 1;
	while (!dq.empty()) {
		int sz = dq.size();
		while (sz--) {
			int i, j;
			tie(i, j) = dq.front();
			dq.pop_front();
			for (int d = 0; d < 4; d++) {
				int n_i = i + dy[d], n_j = j + dx[d];
				if (0 <= n_i && n_i < n && 0 <= n_j && n_j < m) {
					if (grid[n_i][n_j] == 'B') {
						prev_dir[n_i][n_j] = d;
						goto can;
					} else if (grid[n_i][n_j] == '.') {
						prev_dir[n_i][n_j] = d;
						dq.push_back({n_i, n_j});
						grid[n_i][n_j] = '#';
					}
				}
			}
		}
		step++;
	}

	cout << "NO" << '\n';
	return 0;

can:
	cout << "YES" << '\n' << step << '\n';
	vector<char> path;
	for (int i = b.first, j = b.second; grid[i][j] != 'A';) {
		int d = prev_dir[i][j], rd = 3 - d;
		path.push_back(dir_names[d]);
		i += dy[rd];
		j += dx[rd];
	}
	for (auto it = path.rbegin(); it != path.rend(); ++it) cout << *it;
	cout << '\n';
	return 0;
}