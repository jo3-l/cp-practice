#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	int ans = 0;
	for (int i = 0; i < n - 2; i++) {
		for (int j = i + 2; j < n; j++) {
			ans += (j - i - 1) * (i + (n - j - 1));
		}
	}
	cout << ans / 2 << '\n';
}