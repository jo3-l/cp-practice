#include <bits/stdc++.h>

using namespace std;

using ll = long long;

int apples[20];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	ll total_weight = 0;
	for (int i = 0; i < n; i++) {
		cin >> apples[i];
		total_weight += apples[i];
	}

	ll ans = 0x3f3f3f3f3f3f3f3f;
	for (int mask = 1; mask < (1 << n); mask++) {
		ll cur_weight = 0;
		for (int j = 0; j < n; j++) {
			if (mask & (1 << j)) cur_weight += apples[j];
		}
		ans = min(ans, abs(total_weight - cur_weight - cur_weight));
	}

	cout << ans << '\n';
	return 0;
}