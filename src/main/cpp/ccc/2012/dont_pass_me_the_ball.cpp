#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int j;
	cin >> j;
	if (j < 4) cout << 0 << '\n';
	else cout << ((j - 1) * (j - 2) * (j - 3)) / 6 << '\n';

	return 0;
}