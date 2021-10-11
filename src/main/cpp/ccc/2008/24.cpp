#include <bits/stdc++.h>

using namespace std;

constexpr int INF = 0x3f3f3f3f;

int nums[4];

unordered_set<int> solve(int l, int r) {
	if (l == r) return {nums[l]};
	unordered_set<int> ans;
	for (int lhs_border = l; lhs_border < r; lhs_border++) {
		unordered_set<int> lhs = solve(l, lhs_border);
		unordered_set<int> rhs = solve(lhs_border + 1, r);
		for (int x : lhs) {
			for (int y : rhs) {
				ans.insert(x + y);
				ans.insert(x - y);
				ans.insert(x * y);
				if (y && x % y == 0) ans.insert(x / y);
			}
		}
	}
	return ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	while (n--) {
		cin >> nums[0] >> nums[1] >> nums[2] >> nums[3];
		int ans = -INF;
		do {
			for (int v : solve(0, 3))
				if (v <= 24) ans = max(ans, v);
		} while (ans != 24 && next_permutation(begin(nums), end(nums)));
		cout << ans << '\n';
	}

	return 0;
}