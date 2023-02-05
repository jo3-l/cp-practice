#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	array<int, 1 << 10> cnt;
	cnt.fill(0);

	int n;
	cin >> n;
	while (n--) {
		int64_t k;
		cin >> k;
		int digits = 0;
		while (k > 0) {
			digits |= 1 << (k % 10);
			k /= 10;
		}

		for (int sub = digits; sub; sub = (sub - 1) & digits) {
			cnt[sub]++;
		}
	}

	int64_t ans = 0;
	for (int msk = 1; msk < 1 << 10; msk++) {
		int64_t pairs = int64_t(cnt[msk]) * (cnt[msk] - 1) / 2;
		if (__builtin_parity(msk))
			ans += pairs;
		else
			ans -= pairs;
	}
	cout << ans << '\n';

	return 0;
}