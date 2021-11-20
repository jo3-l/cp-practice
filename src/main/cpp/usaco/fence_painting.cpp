#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	freopen("paint.in", "r", stdin);
	freopen("paint.out", "w", stdout);

	int a, b, c, d;
	cin >> a >> b >> c >> d;
	cout << b - a + d - c - max(min(b, d) - max(a, c), 0);

	return 0;
}