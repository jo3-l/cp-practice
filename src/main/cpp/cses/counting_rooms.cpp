#include <bits/stdc++.h>

using namespace std;

char grid[1000][1000];

int n, m;

const int dx[]{1, -1, 0, 0};
const int dy[]{0, 0, 1, -1};

void go(int i, int j) {
	for (int d = 0; d < 4; d++) {
		int n_i = i + dy[d], n_j = j + dx[d];
		if (0 <= n_i && n_i < n && 0 <= n_j && n_j < m && grid[n_i][n_j] == '.') {
			grid[n_i][n_j] = '#';
			go(n_i, n_j);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) cin >> grid[i][j];
	}

	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (grid[i][j] == '.') {
				go(i, j);
				cnt++;
			}
		}
	}
	cout << cnt << '\n';

	return 0;
}