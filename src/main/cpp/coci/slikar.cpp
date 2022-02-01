#include <bits/stdc++.h>

using namespace std;

const int dx[]{1, 0, -1, 0};
const int dy[]{0, 1, 0, -1};

using State = tuple<bool, int, int>;

char forest[50][50];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	deque<State> dq;
	int r, c;
	cin >> r >> c;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> forest[i][j];
			if (forest[i][j] == 'S') dq.push_back({false, i, j});
			else if (forest[i][j] == '*') dq.push_front({true, i, j});
		}
	}

	int time = 1;
	while (!dq.empty()) {
		int sz = dq.size();
		while (sz--) {
			bool is_water;
			int i, j;
			tie(is_water, i, j) = dq.front();
			dq.pop_front();
			for (int d = 0; d < 4; d++) {
				int n_i = i + dy[d], n_j = j + dx[d];
				if (0 <= n_i && n_i < r && 0 <= n_j && n_j < c) {
					if (forest[n_i][n_j] == 'D' && !is_water) goto good;
					if (forest[n_i][n_j] == '.') {
						forest[n_i][n_j] = 'X';
						dq.push_back({is_water, n_i, n_j});
					}
				}
			}
		}
		time++;
	}

	cout << "KAKTUS" << '\n';
	return 0;
good:
	cout << time << '\n';
	return 0;
}