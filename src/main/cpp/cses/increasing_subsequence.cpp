#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 2e5;
int upd_idx[MN];
int t[2 * MN];

int n;

int query(int l, int r) {
	int ans = 0;
	for (l += n, r += n; l < r; l /= 2, r /= 2) {
		if (l & 1) ans = max(ans, t[l++]);
		if (r & 1) ans = max(ans, t[--r]);
	}
	return ans;
}

void update(int i, int val) {
	t[i += n] = val;
	for (; i > 1; i /= 2) t[i / 2] = max(t[i], t[i ^ 1]);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	cin >> n;
	vector<int> nums(n);
	for (auto& x : nums) cin >> x;

	vector<pair<int, int>> enumerated(n);
	for (int i = 0; i < n; i++) enumerated[i] = {nums[i], i};
	sort(enumerated.begin(), enumerated.end());
	for (int i = 0, sorted_pos = 0; i < n; i++) {
		if (i > 0 && enumerated[i].first != enumerated[i - 1].first) sorted_pos++;
		upd_idx[enumerated[i].second] = sorted_pos;
	}

	int ans = 0;
	for (int i = 0; i < n; i++) {
		int cur = query(0, upd_idx[i]) + 1;
		update(upd_idx[i], cur);
		ans = max(ans, cur);
	}
	cout << ans << '\n';
	return 0;
}