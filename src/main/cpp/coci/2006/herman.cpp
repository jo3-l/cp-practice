#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int r;
	cin >> r;
	cout << setprecision(10) << fixed << r * r * M_PI << '\n' << setprecision(10) << fixed << r * r * 2 << '\n';

	return 0;
}