#include <bits/stdc++.h>

using namespace std;

int invited[6]; // invited(i) = bitset of people that person i invited

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	n--; // remove mark
	for (int i = 0; i < n; i++) {
		int j;
		cin >> j;
		invited[j - 1] |= 1 << i;
	}

	// just brute force all the subsets and see if they make sense.
	int cnt = 0;
	for (int i = 0; i < 1 << n; i++) {
		for (int j = 0; j < n; j++) {
			if (i & (1 << j)) {
				// person j is part of the people removed
				// all the people invited (indirectly or directly) by them must also be removed
				int mask = invited[j];
				while (mask) {
					if ((i & mask) != mask) goto impossible;
					int next_mask = 0;
					for (int k = 0; k < n; k++) {
						if (mask & (1 << k)) next_mask |= invited[k];
					}
					mask = next_mask;
				}
			}
		}

		cnt++;
	impossible:;
	}

	cout << cnt << '\n';
	return 0;
}