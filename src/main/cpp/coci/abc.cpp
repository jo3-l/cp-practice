#include <bits/stdc++.h>

using namespace std;

int xs[3];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	for (auto &x : xs) cin >> x;
	if (xs[0] > xs[1]) swap(xs[0], xs[1]);
	if (xs[1] > xs[2]) swap(xs[1], xs[2]);
	if (xs[0] > xs[1]) swap(xs[0], xs[1]);

	for (int i = 0; i < 3; i++) {
		char c;
		cin >> c;
		if (i > 0) cout << ' ';
		cout << xs[c - 'A'];
	}
	cout << '\n';
	return 0;
}