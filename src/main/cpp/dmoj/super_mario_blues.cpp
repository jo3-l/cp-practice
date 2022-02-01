#include <bits/stdc++.h>

using namespace std;

void solve() {
	int a, b;
	cin >> a;
	cin.ignore(1);
	cin >> b;
	int lvls = 0;
	for (; a != 8 || b != 4; lvls++) {
		if (a == 1 && b == 2) {
			a = 4;
			b = 1;
		} else if (a == 4 && b == 2) {
			a = 8;
			b = 1;
		} else if (b == 4) {
			a++;
			b = 1;
		} else {
			b++;
		}
	}
	cout << lvls + 1 << '\n';
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int t;
	cin >> t;
	while (t--) solve();

	return 0;
}