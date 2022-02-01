#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, i, j;
	cin >> n >> i >> j;
	if (abs(i * i - n) < abs(j * j - n)) cout << 1 << '\n';
	else cout << 2 << '\n';

	return 0;
}