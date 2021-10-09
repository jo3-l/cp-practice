#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	int ans = 0;
	for (int large = 1; large <= 5; large++) {
		for (int small = 0; small <= large; small++) {
			ans += large + small == n;
		}
	}

	cout << ans << '\n';
	return 0;
}