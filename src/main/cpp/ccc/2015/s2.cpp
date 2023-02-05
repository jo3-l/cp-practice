#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int j, a;
	cin >> j >> a;
	vector<int> jersey_size(j + 1);
	for (int i = 1; i <= j; i++) {
		char size;
		cin >> size;
		if (size == 'M')
			jersey_size[i] = 1;
		else if (size == 'L')
			jersey_size[i] = 2;
	}

	int ans = 0;
	while (a--) {
		char size;
		int requested;
		cin >> size >> requested;
		if (requested > j) continue;

		bool ok = false;
		if (size == 'S')
			ok = jersey_size[requested] >= 0;
		else if (size == 'M')
			ok = jersey_size[requested] >= 1;
		else
			ok = jersey_size[requested] >= 2;

		if (ok) {
			jersey_size[requested] = -1;
			ans++;
		}
	}

	cout << ans << '\n';
}