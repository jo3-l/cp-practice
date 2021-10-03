#include <bits/stdc++.h>

using namespace std;

bool seen[600][600];

bool add(int x, int y) {
	x += 250;
	y += 250;
	if (seen[x][y]) return true;
	seen[x][y] = true;
	return false;
}

pair<int, int> initial[]{{0, -1}, {0, -2}, {0, -3}, {1, -3}, {2, -3}, {3, -3},	{3, -4},  {3, -5}, {4, -5}, {5, -5},
			 {5, -4}, {5, -3}, {6, -3}, {7, -3}, {7, -4}, {7, -5},	{7, -6},  {7, -7}, {6, -7}, {5, -7},
			 {4, -7}, {3, -7}, {2, -7}, {1, -7}, {0, -7}, {-1, -7}, {-1, -6}, {-1, -5}};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (auto c : initial)
		add(c.first, c.second);

	int x = -1, y = -5;
	char c;
	int n;
	for (cin >> c >> n; c != 'q'; cin >> c >> n) {
		int dx = c == 'l' ? -1 : c == 'r', dy = c == 'd' ? -1 : c == 'u';
		bool danger = false;
		while (n--) {
			x += dx;
			y += dy;
			if (add(x, y)) danger = true;
		}
		cout << x << ' ' << y << ' ' << (danger ? "DANGER" : "safe") << '\n';
		if (danger) break;
	}

	return 0;
}