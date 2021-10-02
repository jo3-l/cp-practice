#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int m, d;
	cin >> m >> d;
	if (m < 2 || (m == 2 && d < 18))
		cout << "Before" << '\n';
	else if (m == 2 && d == 18)
		cout << "Special" << '\n';
	else
		cout << "After" << '\n';

	return 0;
}