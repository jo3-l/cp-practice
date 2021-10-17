#include <bits/stdc++.h>

using namespace std;

bool is_rsa_num(int n) {
	int d = 0;
	for (int i = 1; i <= n && d <= 4; i++) d += n % i == 0;
	return d == 4;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int a, b;
	cin >> a >> b;
	int n = 0;
	for (int i = a; i <= b; i++) n += is_rsa_num(i);
	cout << "The number of RSA numbers between " << a << " and " << b << " is " << n << '\n';

	return 0;
}