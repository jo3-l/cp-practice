#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int a, b, c, d, t;
	cin >> a >> b >> c >> d >> t;
	int baseline = abs(c - a) + abs(d - b); // amount of fuel required to travel directly to dest

	if (t >= baseline && ((t - baseline) & 1) == 0)
		cout << "Y\n";
	else
		cout << "N\n";
}