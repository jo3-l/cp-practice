#include <bits/stdc++.h>

using namespace std;

const int dx[]{1, 0, -1, 0};
const int dy[]{0, 1, 0, -1};

using State = tuple<int, int, int>;

char settings[10][100][100];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int r, c, t;
	cin >> r >> c >> t;
	bool has_b = false;
	deque<tuple<int, int, int>> dq;
	for (int s = 0; s < t; s++) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				cin >> settings[s][i][j];
				if (settings[s][i][j] == 'A') dq.push_back({s, i, j});
				has_b |= settings[s][i][j] == 'B';
			}
		}
	}
	assert(has_b && !dq.empty());

	int moves = 1;
	while (!dq.empty()) {
		int sz = dq.size();
		while (sz--) {
			int s, i, j;
			tie(s, i, j) = dq.front();
			dq.pop_front();
			for (int d = 0; d < 4; d++) {
				int n_i = i + dy[d], n_j = j + dx[d];
				if (0 <= n_i && n_i < r && 0 <= n_j && n_j < c) {
					if (settings[s][n_i][n_j] == 'B') goto possible;
					if (settings[s][n_i][n_j] == '.') {
						settings[s][n_i][n_j] = 'X';
						dq.push_back({s, n_i, n_j});
					}
				}
			}
			for (int ts = 0; ts < t; ts++) {
				if (settings[ts][i][j] == 'B') goto possible;
				if (settings[ts][i][j] == '.') {
					settings[ts][i][j] = 'X';
					dq.push_back({ts, i, j});
				}
			}
		}
		moves++;
	}

	cout << -1 << '\n';
	return 0;
possible:
	cout << moves << '\n';
	return 0;
}