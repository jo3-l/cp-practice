#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int b;
	cin >> b;
	int p = 5 * b - 400;
	cout << p << '\n';
	if (p < 100)
		cout << 1;
	else if (p == 100)
		cout << 0;
	else
		cout << -1;
	cout << '\n';

	return 0;
}