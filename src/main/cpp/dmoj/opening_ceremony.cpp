#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int f, m, b, tf, tm, tb;
	cin >> f >> m >> b >> tf >> tm >> tb;
	cout << (tf + tm + tb) << ' ' << (f * tf + m * tm + b * tb) << '\n';

	return 0;
}