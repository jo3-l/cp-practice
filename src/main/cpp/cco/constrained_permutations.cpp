#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, k;
	cin >> n >> k;
	vector<int> perm(n);
	iota(perm.begin(), perm.end(), 1);
	vector<pair<int, int>> restrictions(k);
	for (auto &[x, y] : restrictions) cin >> x >> y;
	int ans = 0;
	do {
		auto f = [&](auto p) {
			auto [x, y] = p;
			return find(perm.begin(), perm.end(), x) < find(perm.begin(), perm.end(), y);
		};
		if (all_of(restrictions.begin(), restrictions.end(), f)) ans++;
	} while (next_permutation(perm.begin(), perm.end()));
	cout << ans << '\n';
	return 0;
}