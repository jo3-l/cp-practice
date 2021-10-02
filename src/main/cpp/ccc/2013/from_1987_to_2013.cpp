#include <bits/stdc++.h>

using namespace std;

bool all_distinct(int i) {
	int b = 0;
	while (i) {
		int k = 1 << (i % 10);
		if (b & k) return false;
		b |= k;
		i /= 10;
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int y;
	cin >> y;
	do {
		y++;
	} while (!all_distinct(y));
	cout << y << '\n';

	return 0;
}