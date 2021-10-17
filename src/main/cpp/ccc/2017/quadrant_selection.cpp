#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int x, y;
	cin >> x >> y;
	if (x > 0) cout << (y < 0 ? 4 : 1) << '\n';
	else cout << (y < 0 ? 3 : 2) << '\n';

	return 0;
}