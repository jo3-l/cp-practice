#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int t;
	cin >> t;
	while (t--) {
		int a, b;
		cin >> a >> b;
		int y = (2 * a - b) / 3;
		int x = a - 2 * y;
		cout << (x >= 0 && y >= 0 && (a - x - 2 * y) == 0 && (b - y - 2 * x) == 0 ? "YES" : "NO") << '\n';
	}

	return 0;
}