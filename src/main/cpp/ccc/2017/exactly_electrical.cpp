#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int a, b, c, d, t;
	cin >> a >> b >> c >> d >> t;
	int baseline = abs(c - a) + abs(d - b);
	cout << (t < baseline || (t & 1) != (baseline & 1) ? "N" : "Y");

	return 0;
}