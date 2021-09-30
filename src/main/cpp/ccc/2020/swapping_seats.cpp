#include <bits/stdc++.h>

#define dbg(x) cout << #x << " = " << (x) << '\n';
#define popcnt __builtin_popcount
#define popcnt64 __builtin_popcountll
#define clz __builtin_clz
#define clz64 __builtin_clzll
#define ctz __builtin_ctz
#define ctz64 __builtin_ctzll

using namespace std;

using ull = unsigned long long;
using ll = long long;
using uint128 = __int128;

const int MOD = 1e9 + 7;
const int INF = 0x3f3f3f3f;

template <typename T1, typename T2> struct pair_hash {
	ull operator()(pair<T1, T2> const &p) const {
		static const ull R = chrono::steady_clock::now().time_since_epoch().count();
		return hash<T1>{}(p.first ^ R ^ (p.first >> 16)) ^
		       (hash<T2>{}(p.second ^ R ^ (p.first >> 16)) >> 1);
	}
};

int t_cnt[3];

const int MN = 1e6;
int prefix_cnt[MN][3];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string table;
	cin >> table;
	for (int i = 0; i < table.size(); i++) {
		int ct = table[i] - 'A';
		t_cnt[ct]++;
		for (int t = 0; t < 3; t++) {
			if (i > 0) prefix_cnt[i][t] = prefix_cnt[i - 1][t];
			prefix_cnt[i][t] += ct == t;
		}
	}

	auto query_type_fast = [&](int t, int i, int j) {
		int r = prefix_cnt[j][t];
		if (i > 0) r -= prefix_cnt[i - 1][t];
		return r;
	};

	auto query_type = [&](int t, int i, int j) {
		j--; // make j inclusive
		if (i > j) return 0;
		if (j >= table.size()) {
			// there's some elements that wrap around to the front
			// split into two queries
			return query_type_fast(t, i, table.size() - 1) +
			       query_type_fast(t, 0, j - table.size());
		}
		return query_type_fast(t, i, j);
	};

	// Similar to CCC 2021 J4 (arranging books).
	// We just need to 1) build a prefix sum array so we can answer queries
	// of the type "how many x are in some range" and 2) brute force all
	// possible valid group combinations (the number of them is linear in
	// the length of the string). Given that we can answer 1) in constant
	// time, we can then get the amount of swaps needed for any given combo
	// in constant time, resulting in a linear runtime overall.
	int ans = INF;
	for (int a_start = 0; a_start < table.size(); a_start++) {
		int a_t = 0;
		for (int b_t = 1; b_t <= 2; b_t++) {
			int c_t = 3 - b_t;

			int a_end = a_start + t_cnt[a_t], b_start = a_end % table.size(),
			    b_end = b_start + t_cnt[b_t], c_start = b_end % table.size(),
			    c_end = c_start + t_cnt[c_t];

			int a_in_b = query_type(a_t, b_start, b_end),
			    a_in_c = query_type(a_t, c_start, c_end),
			    c_in_a = query_type(c_t, a_start, a_end),
			    c_in_b = query_type(c_t, b_start, b_end);
			int a_c_swaps = min(a_in_c, c_in_a);
			ans = min(ans, a_in_b + a_in_c + c_in_b + c_in_a - a_c_swaps);
		};
	}
	cout << ans << '\n';
	return 0;
}