#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	vector<int> cows(n);
	for (auto& cow : cows) cin >> cow;

	int t;
	cin >> t;
	for (int i = 0; i < t; i++) {
		if (i > 0) cout << ' ';
		int64_t target;
		cin >> target;

		unordered_map<int64_t, int> seen{{0, 1}};
		int64_t total = 0;
		int64_t ans = 0;
		for (int cow : cows) {
			total += cow;
			auto it = seen.find(total - target);
			if (it != seen.end()) ans += it->second;
			seen[total]++;
		}
		cout << ans;
	}

	cout << '\n';
	return 0;
}