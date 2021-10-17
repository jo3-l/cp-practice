#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int m, n;
	cin >> m >> n;
	int w = max(min(m, 9) - max(1, 10 - n) + 1, 0);
	if (w == 1) cout << "There is 1 way to get the sum 10." << '\n';
	else cout << "There are " << w << " ways to get the sum 10." << '\n';
	return 0;
}