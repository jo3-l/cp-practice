#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int a, e;
	cin >> a >> e;
	if (a >= 3 && e <= 4) cout << "TroyMartian" << '\n';
	if (a <= 6 && e >= 2) cout << "VladSaturnian" << '\n';
	if (a <= 2 && e <= 3) cout << "GraemeMercurian" << '\n';

	return 0;
}