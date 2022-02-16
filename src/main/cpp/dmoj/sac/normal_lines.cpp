#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int x1, y1;
	int x2, y2;
	cin >> x1 >> y1 >> x2 >> y2;
	if (y1 == y2) cout << "x-axis\n";
	else if (x1 == x2) cout << "y-axis\n";
	else cout << "neither\n";

	return 0;
}