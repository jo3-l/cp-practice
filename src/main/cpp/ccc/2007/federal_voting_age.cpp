#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	while (n--) {
		int y, m, d;
		cin >> y >> m >> d;
		if (y > 2007 - 18) {
			cout << "No" << '\n';
		} else if (y == 2007 - 18) {
			cout << (m < 2 || (m == 2 && d <= 27) ? "Yes" : "No") << '\n';
		} else {
			cout << "Yes" << '\n';
		}
	}

	return 0;
}