#include <bits/stdc++.h>

using namespace std;

using ll = long long;

void solve() {
	ll k;
	cin >> k;
	int i = 1;
	ll ten_pow = 1, offset = 0;
	for (;; i++, ten_pow *= 10) {
		if (offset + i * 9 * ten_pow >= k) break;
		offset += i * ten_pow * 9;
	}
	k -= offset + 1;
	ll n = ten_pow + (k / i);
	int shft = i - (k % i) - 1;
	while (shft-- > 0) n /= 10;
	cout << n % 10 << '\n';
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int q;
	cin >> q;
	while (q--) solve();

	return 0;
}