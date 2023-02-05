#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int a, b, c, d;
	cin >> a >> b >> c >> d;
	cout << (((a == 8 || a == 9) && (d == 8 || d == 9) && b == c) ? "ignore" : "answer") << '\n';
}