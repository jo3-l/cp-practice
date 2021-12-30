#include <bits/stdc++.h>

using namespace std;

int sum_divs(int n) {
	int s = 0;
	for (int i = 1; i < n; i++) {
		if (n % i == 0) s += i;
	}
	return s;
}

int cube(int n) { return n * n * n; }

int cube_digits(int n) {
	int s = 0;
	for (; n > 0; n /= 10) s += cube(n % 10);
	return s;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	for (int n = 1000, cnt = 0; n <= 9999; n++) {
		if (sum_divs(n) == n) {
			if (cnt++ > 0) cout << ' ';
			cout << n;
		}
	}
	cout << '\n';
	for (int n = 100, cnt = 0; n <= 999; n++) {
		if (cube_digits(n) == n) {
			if (cnt++ > 0) cout << ' ';
			cout << n;
		}
	}
	cout << '\n';
	return 0;
}