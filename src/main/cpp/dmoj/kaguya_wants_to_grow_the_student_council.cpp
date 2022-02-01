#include <bits/stdc++.h>

using namespace std;

int lower[26]; // ones we can put lower

int dfs(int seen, int cur) {
	if (!lower[cur]) return 1;
	int ans = 0;
	for (int m = lower[cur]; m > 0; m &= m - 1) {
		int nxt = __builtin_ctz(m);
		if (seen & (1 << nxt)) {
			// cycle, bad
			return 0;
		}
		ans = max(ans, dfs(seen | (1 << nxt), nxt));
	}
	return ans + 1;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, k;
	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		int prev = 0;
		for (int j = 0; j < k; j++) {
			char c;
			cin >> c;
			for (int m = prev; m > 0; m &= m - 1) {
				lower[__builtin_ctz(m)] |= 1 << (c - 'A');
			}
			prev |= 1 << (c - 'A');
		}
	}

	// remove direct cycles
	for (int a = 0; a < k; a++) {
		for (int b = 0; b < k; b++) {
			int a_bit = 1 << a, b_bit = 1 << b;
			if ((lower[a] & b_bit) && (lower[b] & a_bit)) {
				lower[a] &= ~b_bit;
				lower[b] &= ~a_bit;
			}
		}
	}

	// longest path that doesn't lead to a cycle
	int ans = 0;
	for (int first = 0; first < k; first++) {
		ans = max(ans, dfs(1 << first, first));
	}
	cout << ans << '\n';

	return 0;
}