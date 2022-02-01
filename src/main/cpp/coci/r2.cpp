#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int r1, s;
	cin >> r1 >> s;
	// r1 + r2 = s * 2
	// r2 = s * 2 - r1
	cout << s * 2 - r1 << '\n';

	return 0;
}