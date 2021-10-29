#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, d;
	cin >> n >> d;
	bool neg = (n < 0) != (d < 0);
	n = abs(n), d = abs(d);
	int w = n / d;
	n -= d * w;
	if (w) {
		if (neg) cout << '-';
		cout << w;
	}
	if (n) {
		int g = __gcd(n, d);
		n /= g, d /= g;
		if (w) cout << ' ';
		cout << n << '/' << d;
	}
	cout << '\n';
	return 0;
}