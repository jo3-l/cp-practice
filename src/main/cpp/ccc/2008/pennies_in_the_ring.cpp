#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int r;
	for (cin >> r; r; cin >> r) {
		int ans = 0;
		for (int x = 0; x <= r; x++)
			ans += 4 * floor(sqrt((r * r) - (x * x)));
		cout << ans + 1 << '\n';
	}

	return 0;
}