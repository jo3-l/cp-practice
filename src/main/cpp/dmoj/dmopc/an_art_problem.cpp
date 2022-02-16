#include <bits/stdc++.h>

using namespace std;

const int dx[]{1, 0, -1, 0};
const int dy[]{0, 1, 0, -1};

constexpr int MN = 1500, MM = 1500;
int color[MN][MM];
int colored_at[MN][MM];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	memset(colored_at, 0x3f, sizeof(colored_at));
	queue<pair<int, int>> q;
	int n, m, k;
	cin >> n >> m >> k;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> color[i][j];
			if (color[i][j]) {
				q.push({i, j});
				colored_at[i][j] = 0;
			}
		}
	}

	int time = 1;
	while (!q.empty() && time <= k) {
		int sz = q.size();
		while (sz--) {
			auto [i, j] = q.front();
			int clr = color[i][j];
			q.pop();
			for (int d = 0; d < 4; d++) {
				int n_i = i + dy[d], n_j = j + dx[d];
				if (0 <= n_i && n_i < n && 0 <= n_j && n_j < m) {
					if (colored_at[n_i][n_j] > time) {
						color[n_i][n_j] = clr;
						colored_at[n_i][n_j] = time;
						q.push({n_i, n_j});
					} else if (colored_at[n_i][n_j] == time) {
						if (color[n_i][n_j] == 0 || clr < color[n_i][n_j]) color[n_i][n_j] = clr;
					}
				}
			}
		}
		time++;
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (j > 0) cout << ' ';
			cout << color[i][j];
		}
		cout << '\n';
	}

	return 0;
}