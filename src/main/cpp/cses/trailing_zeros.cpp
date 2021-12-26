#include <bits/stdc++.h>

using namespace std;

using ll = long long;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	int x = 0;
	for (ll v = 5; v <= n; v *= 5) x += n / v;
	cout << x << '\n';

	return 0;
}