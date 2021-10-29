#include <bits/stdc++.h>

using namespace std;

int spiral[20][20];

const int dx[]{0, 1, 0, -1};
const int dy[]{1, 0, -1, 0};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int a, b;
	cin >> a >> b;
	int x = 10, y = 10;
	int min_x = x, min_y = y, max_x = x, max_y = y;
	int spiral_len = 1, dir = 0;
	spiral[x][y] = a++;
	for (; a <= b; spiral_len++) {
		for (int i = 0; i < 2; i++, dir = (dir + 1) % 4) {
			for (int stop = min(b, a + spiral_len - 1); a <= stop; a++) {
				spiral[y += dy[dir]][x += dx[dir]] = a;
				min_x = min(min_x, x);
				min_y = min(min_y, y);
				max_x = max(max_x, x);
				max_y = max(max_y, y);
			}
		}
	}

	for (int y = min_y; y <= max_y; y++) {
		for (int x = min_x; x <= max_x; x++) {
			if (spiral[y][x]) cout << ' ' << spiral[y][x];
		}
		cout << '\n';
	}
	return 0;
}
