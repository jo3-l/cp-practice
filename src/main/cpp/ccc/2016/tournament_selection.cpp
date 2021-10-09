#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int wins;
	for (int i = 0; i < 6; i++) {
		char c;
		cin >> c;
		if (c == 'W') wins++;
	}

	if (wins >= 5)
		cout << 1 << '\n';
	else if (wins >= 3)
		cout << 2 << '\n';
	else if (wins >= 1)
		cout << 3 << '\n';
	else
		cout << -1 << '\n';

	return 0;
}