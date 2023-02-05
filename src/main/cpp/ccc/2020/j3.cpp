#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;

	int min_x = 101, max_x = -1, min_y = 101, max_y = -1;
	while (n--) {
		int x, y;
		cin >> x;
		cin.ignore(1);
		cin >> y;

		min_x = min(min_x, x);
		max_x = max(max_x, x);
		min_y = min(min_y, y);
		max_y = max(max_y, y);
	}
	cout << (min_x - 1) << ',' << (min_y - 1) << '\n';
	cout << (max_x + 1) << ',' << (max_y + 1) << '\n';
}