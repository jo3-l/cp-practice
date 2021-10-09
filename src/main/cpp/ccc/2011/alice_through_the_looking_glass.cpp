#include <bits/stdc++.h>

using namespace std;

int square_size[]{0, 1, 5, 25, 125, 625, 3125, 15625, 78125, 390625, 1953125, 9765625, 48828125, 244140625};

bool definitely_crystal[5][5];
bool defer[5][5];

bool is_crystal(int lvl, int x, int y) {
	if (lvl == 0) return false;
	int sx = x / square_size[lvl], sy = y / square_size[lvl];
	if (definitely_crystal[sx][sy]) return true;
	return defer[sx][sy] && is_crystal(lvl - 1, x % square_size[lvl], y % square_size[lvl]);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	definitely_crystal[1][0] = definitely_crystal[2][0] = definitely_crystal[3][0] = definitely_crystal[2][1] =
	    true;
	defer[1][1] = defer[2][2] = defer[3][1] = true;

	int t;
	cin >> t;
	while (t--) {
		int m, x, y;
		cin >> m >> x >> y;
		cout << (is_crystal(m, x, y) ? "crystal" : "empty") << '\n';
	}

	return 0;
}