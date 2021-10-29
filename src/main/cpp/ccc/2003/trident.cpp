#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int t, s, h;
	cin >> t >> s >> h;
	while (t--) {
		for (int i = 0; i < 3; i++) {
			if (i > 0) cout << setw(s + 1);
			cout << '*';
		}
		cout << '\n';
	}
	for (int i = 0; i < 2 * s + 3; i++) cout << '*';
	cout << '\n';
	for (int i = 0; i < h; i++) cout << setw(s + 2) << '*' << '\n';

	return 0;
}