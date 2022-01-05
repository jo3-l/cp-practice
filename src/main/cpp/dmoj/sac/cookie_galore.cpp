#include <bits/stdc++.h>

using namespace std;

constexpr char SEEN = '*';

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
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) cin >> grid[i][j];
	}
	if (n == 1 && m == 1) {
		cout << (int)(grid[0][0] == 'C') << '\n';
		return 0;
	}

	deque<tuple<int, int, int>> dq{{0, 0, grid[0][0] == 'C'}};
	while (!dq.empty()) {
		int i, j, eaten;
		tie(i, j, eaten) = dq.front();
		dq.pop_front();
		for (int d = 0; d < 4; d++) {
			int n_i = i + dy[d], n_j = j + dx[d];
			if (0 <= n_i && n_i < n && 0 <= n_j && n_j < m) {
				bool has_cookie = grid[n_i][n_j] == 'C';
				if (n_i == n - 1 && n_j == m - 1) {
					cout << eaten + has_cookie << '\n';
					return 0;
				}

				if (grid[n_i][n_j] != SEEN) {
					if (has_cookie) dq.push_back({n_i, n_j, eaten + 1});
					else dq.push_front({n_i, n_j, eaten});
					grid[n_i][n_j] = SEEN;
				}
			}
		}
	}

	assert(false); // should always be an answer
	return 0;
}