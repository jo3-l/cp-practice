#include <bits/stdc++.h>

using namespace std;

const int dx[]{1, 2, 2, 1, -1, -2, -2, -1};
const int dy[]{2, 1, -1, -2, -2, -1, 1, 2};

bool vis[8][8];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int sx, sy, tx, ty;
	cin >> sx >> sy >> tx >> ty;
	sx--, sy--, tx--, ty--;
	if (sx == tx && sy == ty) {
		cout << 0 << '\n';
		return 0;
	}

	queue<pair<int, int>> q;
	q.push({sx, sy});
	int moves = 1;
	while (!q.empty()) {
		int sz = q.size();
		while (sz--) {
			int x, y;
			tie(x, y) = q.front();
			q.pop();
			for (int d = 0; d < 8; d++) {
				int nx = x + dx[d], ny = y + dy[d];
				if (nx == tx && ny == ty) {
					cout << moves << '\n';
					return 0;
				}
				if (0 <= nx && nx <= 8 && 0 <= ny && ny < 8 && !vis[nx][ny]) {
					vis[nx][ny] = true;
					q.push({nx, ny});
				}
			}
		}
		moves++;
	}
	return 0;
}