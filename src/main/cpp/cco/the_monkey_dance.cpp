#include <bits/stdc++.h>

using namespace std;
using ll = long long;

int nxt[101];

ll lcm(ll a, ll b) {
	return a * b / __gcd(a, b);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	while (cin >> n) {
		if (!n) break;

		memset(nxt, 0, sizeof(nxt));
		for (int i = 0; i < n; i++) {
			int x, y;
			cin >> x >> y;
			nxt[x] = y;
		}

		// find cycle lengths
		ll ans = n > 1;
		for (int i = 1; i <= n; i++) {
			int len = 0;
			int cur = i;
			do {
				cur = nxt[cur];
				len++;
			} while (cur != i);
			ans = lcm(ans, len);
		}
		cout << ans << '\n';
	}

	return 0;
}