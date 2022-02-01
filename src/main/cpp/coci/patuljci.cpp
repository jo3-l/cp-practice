#include <bits/stdc++.h>

using namespace std;

int xs[9];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int sum = 0;
	for (auto &x : xs) {
		cin >> x;
		sum += x;
	}

	for (int i = 1; i < 9; i++) {
		for (int j = 0; j < i; j++) {
			if (sum - xs[i] - xs[j] == 100) {
				int retain = ((1 << 9) - 1) & ~(1 << i) & ~(1 << j);
				for (; retain > 0; retain &= retain - 1) cout << xs[__builtin_ctz(retain)] << '\n';
				return 0;
			}
		}
	}

	assert(false);
	return 0;
}