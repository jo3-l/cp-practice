#include <bits/stdc++.h>

#define dbg(x) cout << #x << " = " << (x) << '\n'

using namespace std;

const int dx[]{1, 0, -1, 0};
const int dy[]{0, 1, 0, -1};

constexpr int MX = 20, MY = 20;
bool vis[MX][MY];

int w, h, cw, ch, n;

bool is_valid(int x, int y) {
	if (x < 0 || x >= w || y < 0 || y >= h || vis[x][y]) return false;
	return (cw <= x && x < (w - cw)) || (ch <= y && y < (h - ch));
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> w >> h >> cw >> ch >> n;
	int pref_dir = 0;
	int x = cw, y = 0;
	vis[x][y] = true;
	while (n--) {
		int k = pref_dir + 4;
		for (; pref_dir < k; pref_dir++) {
			if (is_valid(x + dx[pref_dir % 4], y + dy[pref_dir % 4])) {
				x += dx[pref_dir % 4];
				y += dy[pref_dir % 4];
				break;
			}
			if (is_valid(x + dx[(pref_dir + 1) % 4], y + dy[(pref_dir + 1) % 4])) {
				x += dx[(pref_dir + 1) % 4];
				y += dy[(pref_dir + 1) % 4];
				break;
			}
		}

		if (pref_dir >= k) break;
		pref_dir %= 4;
		vis[x][y] = true;
	}

	cout << (x + 1) << '\n' << (y + 1) << '\n';
	return 0;
}