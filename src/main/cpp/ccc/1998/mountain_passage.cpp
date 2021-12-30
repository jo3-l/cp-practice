#include <bits/stdc++.h>

using namespace std;

const int dx[]{1, 0, -1, 0};
const int dy[]{0, 1, 0, -1};

int elevation[26][26];
bool seen[26][26];

int solve() {
	int n;
	cin >> n;
	for (int x = 1; x <= n; x++) {
		for (int y = 1; y <= n; y++) cin >> elevation[x][y];
	}
	if (n <= 1) return 0;

	memset(seen, false, sizeof(seen));
	seen[1][1] = true;
	deque<tuple<int, int, int>> dq{{1, 1, 0}};
	while (!dq.empty()) {
		int x, y, consumed;
		tie(x, y, consumed) = dq.front();
		dq.pop_front();
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d], ny = y + dy[d];
			if (1 <= nx && nx <= n && 1 <= ny && ny <= n && !seen[nx][ny] && abs(elevation[nx][ny] - elevation[x][y]) <= 2) {
				bool do_consume = elevation[nx][ny] > elevation[1][1] || elevation[x][y] > elevation[1][1];
				if (nx == n && ny == n) return consumed + do_consume;
				seen[nx][ny] = true;
				if (do_consume) dq.push_back({nx, ny, consumed + 1});
				else dq.push_front({nx, ny, consumed});
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
	for (int tc = 0; tc < t; tc++) {
		if (tc > 0) cout << "\n\n";
		int ans = solve();
		if (ans == -1) cout << "CANNOT MAKE THE TRIP";
		else cout << ans;
	}
	cout << '\n';
	return 0;
}