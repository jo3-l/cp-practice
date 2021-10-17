#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int c, r;
	cin >> c >> r;
	int x = 0, y = 0;
	int dx, dy;
	for (cin >> dx >> dy; dx || dy; cin >> dx >> dy) {
		x += dx;
		if (x < 0) x = 0;
		else if (x > c) x = c;

		y += dy;
		if (y < 0) y = 0;
		else if (y > r) y = r;

		cout << x << ' ' << y << '\n';
	}

	return 0;
}