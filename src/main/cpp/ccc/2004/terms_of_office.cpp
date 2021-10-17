#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int x, y;
	cin >> x >> y;
	for (; x <= y; x += 60) cout << "All positions change in year " << x << '\n';

	return 0;
}