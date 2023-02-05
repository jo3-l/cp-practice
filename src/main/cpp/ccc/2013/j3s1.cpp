#include <bits/stdc++.h>

using namespace std;

bool all_distinct(int i) {
	int seen = 0;
	while (i) {
		int k = 1 << (i % 10);
		if (seen & k) return false;
		seen |= k;
		i /= 10;
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int y;
	cin >> y;
	do {
		y++;
	} while (!all_distinct(y));
	cout << y << '\n';
}