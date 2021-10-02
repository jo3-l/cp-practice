#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;

	int cost = 0;
	while (n > 1) {
		for (int i = 2; i <= n; i++) {
			// greedy algorithm - choose first factor (so a is maximal)... just works :P
			// no idea why it does mathematically, though
			if (n % i == 0) {
				// cur = a * b + a
				// cost += b
				int a = n / i;
				n -= a;	       // a * b + a - a = a * b
				cost += n / a; // n = a * b; divide by a and we get b
				break;
			}
		}
	}

	cout << cost << '\n';
	return 0;
}