#include <bits/stdc++.h>

using namespace std;

constexpr int MJ = 1'000'001;
int jerseys[MJ];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int j, a;
	cin >> j >> a;
	for (int i = 1; i <= j; i++) {
		char size;
		cin >> size;
		if (size == 'M')
			jerseys[i] = 1;
		else if (size == 'L')
			jerseys[i] = 2;
	}

	int ans = 0;
	while (a--) {
		char size;
		int requested;
		cin >> size >> requested;
		if (requested > j) continue;

		bool ok = false;
		if (size == 'S')
			ok = jerseys[requested] >= 0;
		else if (size == 'M')
			ok = jerseys[requested] >= 1;
		else
			ok = jerseys[requested] >= 2;

		if (ok) {
			jerseys[requested] = -1;
			ans++;
		}
	}

	cout << ans << '\n';
	return 0;
}