#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 20;
int diff[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	for (cin >> n; n != 0; cin >> n) {
		int prev;
		for (int i = 0; i < n; i++) {
			int k;
			cin >> k;
			if (i > 0) diff[i - 1] = k - prev;
			prev = k;
		}

		if (n == 1) {
			cout << 0 << '\n';
			continue;
		}

		n--;
		for (int len = 1; len <= n; len++) {
			int i;
			for (i = len; i < n; i++)
				if (diff[i] != diff[i % len]) break;

			if (i >= n) {
				cout << len << '\n';
				break;
			}
		}
	}

	return 0;
}