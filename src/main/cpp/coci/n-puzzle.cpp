#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int ans = 0;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			char c;
			cin >> c;
			if (c != '.') ans += abs(i - (c - 'A') / 4) + abs(j - (c - 'A') % 4);
		}
	}

	cout << ans << '\n';
	return 0;
}