#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	vector<pair<int, int>> ingredients(n);
	for (auto& [S, B] : ingredients) cin >> S >> B;
	int ans = numeric_limits<int>::max();
	for (int msk = 1; msk < 1 << n; msk++) {
		int total_s = 1, total_b = 0;
		for (int i = 0; i < n; i++) {
			if (msk >> i & 1) {
				auto [s, b] = ingredients[i];
				total_s *= s;
				total_b += b;
			}
		}
		ans = min(ans, abs(total_s - total_b));
	}
	cout << ans << '\n';
}