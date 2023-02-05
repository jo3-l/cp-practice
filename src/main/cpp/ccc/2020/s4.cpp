#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	string table;
	cin >> table;

	array<int, 3> group_member_cnt{};
	vector<array<int, 3>> prefix_cnt(table.size());
	for (int i = 0; i < table.size(); i++) {
		int group_t = table[i] - 'A';
		group_member_cnt[group_t]++;
		for (int t = 0; t < 3; t++) {
			if (i > 0) prefix_cnt[i][t] = prefix_cnt[i - 1][t];
			prefix_cnt[i][t] += group_t == t;
		}
	}

	auto query_continuous = [&](int group_type, int i, int j) {
		int r = prefix_cnt[j][group_type];
		if (i > 0) r -= prefix_cnt[i - 1][group_type];
		return r;
	};

	auto query = [&](int group_type, int i, int j) {
		j--; // make j inclusive
		if (i > j) return 0;
		if (j >= table.size()) {
			// wraps around; split into two queries
			return query_continuous(group_type, i, table.size() - 1) + query_continuous(group_type, 0, j - table.size());
		}
		return query_continuous(group_type, i, j);
	};

	int ans = numeric_limits<int>::max();
	for (int a_start = 0; a_start < table.size(); a_start++) {
		int a_t = 0;
		for (int b_t = 1; b_t <= 2; b_t++) {
			int c_t = 3 - b_t;

			// clang-format off
			int a_end = a_start + group_member_cnt[a_t],
				b_start = a_end % table.size(), b_end = b_start + group_member_cnt[b_t],
			    c_start = b_end % table.size(), c_end = c_start + group_member_cnt[c_t];

			int a_in_b = query(a_t, b_start, b_end),
				a_in_c = query(a_t, c_start, c_end),
				c_in_a = query(c_t, a_start, a_end),
			    c_in_b = query(c_t, b_start, b_end);
			// clang-format on
			int a_c_swaps = min(a_in_c, c_in_a);
			ans = min(ans, a_in_b + a_in_c + c_in_b + c_in_a - a_c_swaps);
		};
	}
	cout << ans << '\n';
}