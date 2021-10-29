#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int x, m;
	cin >> x >> m;
	for (int n = 1; n <= m; n++) {
		if (((x * n) % m) == 1) {
			cout << n << '\n';
			return 0;
		}
	}
	cout << "No such integer exists." << '\n';
	return 0;
}
