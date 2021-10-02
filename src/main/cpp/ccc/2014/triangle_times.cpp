#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int x, y, z;
	cin >> x >> y >> z;
	if (x + y + z != 180)
		cout << "Error" << '\n';
	else if (x == 60 && y == 60)
		cout << "Equilateral" << '\n';
	else if (x == y || x == z || y == z)
		cout << "Isosceles" << '\n';
	else
		cout << "Scalene" << '\n';

	return 0;
}