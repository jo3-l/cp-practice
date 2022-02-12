#include <bits/stdc++.h>

using namespace std;

const int dx[]{1, 0, -1, 0};
const int dy[]{0, 1, 0, -1};

char grid[50][50];

int solve() {
	int r, c;
	cin >> c >> r;
	queue<pair<int, int>> q;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> grid[i][j];
			if (grid[i][j] == 'C') q.push({i, j});
		}
	}
	for (int step = 1; step < 60 && !q.empty(); step++) {
		int sz = q.size();
		while (sz--) {
			auto [i, j] = q.front();
			q.pop();
			for (int d = 0; d < 4; d++) {
				int n_i = i + dy[d], n_j = j + dx[d];
				if (0 <= n_i && n_i < r && 0 <= n_j && n_j < c) {
					if (grid[n_i][n_j] == 'W') return step;
					if (grid[n_i][n_j] == 'O') {
						grid[n_i][n_j] = 'X';
						q.push({n_i, n_j});
					}
				}
			}
		}
	}
	return -1;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int t;
	cin >> t;
	while (t--) {
		int ans = solve();
		if (ans == -1) cout << "#notworth" << '\n';
		else cout << ans << '\n';
	}

	return 0;
}