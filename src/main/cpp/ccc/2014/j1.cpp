#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int a, b, c;
	cin >> a >> b >> c;
	if (a + b + c != 180) cout << "Error\n";
	else if (a == 60 && b == 60 && c == 60) cout << "Equilateral\n";
	else if (a == b || a == c || b == c) cout << "Isosceles\n";
	else cout << "Scalene\n";
}