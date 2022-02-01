#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	int numerator;
	cin >> numerator;
	for (n--; n--; ) {
		int denom;
		cin >> denom;
		int r_f = __gcd(numerator, denom);
		cout << (numerator / r_f) << '/' << (denom / r_f) << '\n';
	}

	return 0;
}