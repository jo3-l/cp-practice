#include <bits/stdc++.h>

using namespace std;

const int dx[]{0, 1, 0, -1};
const int dy[]{1, 0, -1, 0};

enum Dir { NORTH, EAST, SOUTH, WEST };

void solve() {
	int x = 0, y = 0, d = 0;
	int t;
	for (cin >> t; t != 0; cin >> t) {
		if (t == 1) {
			int n;
			cin >> n;
			x += dx[d] * n;
			y += dy[d] * n;
		} else if (t == 2) {
			d = (d + 1) % 4;
		} else {
			d = (d - 1 + 4) % 4;
		}
	}

	auto dir_to = [&](int tx, int ty) {
		assert(tx == x || ty == y);
		if (tx == x) return ty > y ? NORTH : SOUTH;
		return tx > x ? EAST : WEST;
	};
	auto turns_to_dir = [&](int nd) { return min((nd - d + 4) % 4, (d - nd + 4) % 4); };
	auto change_dir = [&](int nd) {
		int lft = (d - nd + 4) % 4, rgt = (nd - d + 4) % 4;
		int cmd = rgt < lft ? 2 : 3;
		for (int i = 0; i < min(lft, rgt); i++) cout << cmd << '\n';
		d = nd;
	};
	auto move_fwd = [&](int n) {
		cout << '1' << '\n' << n << '\n';
		x += dx[d] * n;
		y += dy[d] * n;
	};

	cout << "Distance is " << abs(x) + abs(y) << '\n';
	if (x == 0 && y == 0) return;
	if (x == 0 || y == 0) {
		change_dir(dir_to(0, 0));
		move_fwd(max(abs(x), abs(y)));
	} else if (turns_to_dir(dir_to(0, y)) < turns_to_dir(dir_to(x, 0))) {
		change_dir(dir_to(0, y));
		move_fwd(abs(x));
		change_dir(dir_to(0, 0));
		move_fwd(abs(y));
	} else {
		change_dir(dir_to(x, 0));
		move_fwd(abs(y));
		change_dir(dir_to(0, 0));
		move_fwd(abs(x));
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int t;
	cin >> t;
	for (int tc = 0; tc < t; tc++) {
		solve();
		if (tc < t - 1) cout << '\n';
	}
	return 0;
}