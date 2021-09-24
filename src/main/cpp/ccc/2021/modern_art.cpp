#include <bits/stdc++.h>

#define dbg(x) cout << #x << " = " << (x) << '\n';
#define popcnt __popcnt
#define popcnt64 __popcnt64
#define clz __builtin_clz
#define clz64 __builtin_clzll
#define ctz __builtin_ctz
#define ctz64 __builtin_ctzll

using namespace std;

using i64 = long long;
using i128 = __int128;

const int MOD = 1e9 + 7;
const int INF = 1e9;

template <typename T1, typename T2> struct pair_hash {
	size_t operator()(pair<T1, T2> const &p) const {
		return hash<T1>(p.first) ^ hash<T2>(p.second);
	}
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int m;
	cin >> m;
	int n;
	cin >> n;

	// Keep track of the number of times a certain row/column has been
	// colored.
	vector<int> row_color_cnt(m, 0);
	vector<int> col_color_cnt(n, 0);

	int k;
	cin >> k;
	while (k--) {
		char c;
		cin >> c;
		int v;
		cin >> v;
		v--; // 1-based to 0-based
		if (c == 'R')
			row_color_cnt[v]++;
		else
			col_color_cnt[v]++;
	};

	int gold = 0;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			// The point (i, j) is colored gold if the number of
			// times it has been colored over is odd. This is
			// because coloring over the same point an even number
			// of times has no effect.
			int total = row_color_cnt[i] + col_color_cnt[j];
			gold += total & 1;
		}
	}
	cout << gold << '\n';

	return 0;
}