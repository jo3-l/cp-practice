#include <bits/stdc++.h>

using namespace std;

unordered_map<int, int> diff; // diff[i] = spookiness of house i - spookiness of house i - 1

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int l, n, s;
	cin >> n >> l >> s;
	diff[1] = diff[l + 1] = 0;
	while (n--) {
		int a, b, inc;
		cin >> a >> b >> inc;
		diff[a] += inc;
		diff[b + 1] -= inc;
	}

	vector<pair<int, int>> entries(diff.begin(), diff.end());
	sort(entries.begin(), entries.end());

	int cur = 0;
	int ans = 0;
	for (int i = 0; i < entries.size() - 1; i++) {
		cur += entries[i].second;
		if (cur < s) ans += entries[i + 1].first - entries[i].first;
	}

	cout << ans << '\n';
	return 0;
}