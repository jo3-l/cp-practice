#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int extra_x = 0;
	int extra_y = 0;
	for (int i = 0; i < 3; i++) {
		int x, y;
		cin >> x >> y;
		extra_x ^= x;
		extra_y ^= y;
	}
	cout << extra_x << ' ' << extra_y << '\n';
}