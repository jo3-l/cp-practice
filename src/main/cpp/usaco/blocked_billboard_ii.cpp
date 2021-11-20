#include <bits/stdc++.h>

using namespace std;

bool completely_contains(int a, int b, int c, int d) { return a <= c && d <= b; }

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	freopen("billboard.in", "r", stdin);
	freopen("billboard.out", "w", stdout);

	int x1, y1, x2, y2, x3, y3, x4, y4;
	cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3 >> x4 >> y4;
	bool complete_x_overlap = completely_contains(x3, x4, x1, x2);
	bool complete_y_overlap = completely_contains(y3, y4, y1, y2);
	if (complete_x_overlap && complete_y_overlap) {
		cout << 0 << '\n';
		return 0;
	}

	if (complete_x_overlap && !completely_contains(y1, y2, y3, y4)) {
		if (y4 > y2) y2 = y3;
		else y1 = y4;
	}
	if (complete_y_overlap && !completely_contains(x1, x2, x3, x4)) {
		if (x4 > x2) x2 = x3;
		else x1 = x4;
	}
	cout << (x2 - x1) * (y2 - y1) << '\n';
	return 0;
}