#include <bits/stdc++.h>

using namespace std;

int times_played[3];
const int payout[]{30, 60, 9};
const int cycle[]{35, 100, 10};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int q;
	cin >> q;
	for (int i = 0; i < 3; i++) cin >> times_played[i];
	int n;
	for (n = 1; --q > 0; n++) {
		int m = n % 3;
		if (++times_played[m] == cycle[m]) {
			times_played[m] = 0;
			q += payout[m];
		}
	}

	cout << "Martha plays " << n << " times before going broke." << '\n';
	return 0;
}