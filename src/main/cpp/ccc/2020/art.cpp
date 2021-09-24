#include <bits/stdc++.h>

#define dbg(x) cout << #x << " = " << (x) << '\n';
#define popcnt __popcount
#define popcnt64 __popcountll
#define clz __builtin_clz
#define clz64 __builtin_clzll
#define ctz __builtin_ctz
#define ctz64 __builtin_ctzll

using namespace std;

using ll = long long;
using uint128 = __int128;

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

	int n;
	cin >> n;

	int min_x = 101, max_x = -1, min_y = 101, max_y = -1;
	while (n--) {
		int x, y;
		cin >> x;
		cin.ignore(1);
		cin >> y;

		min_x = min(min_x, x);
		max_x = max(max_x, x);
		min_y = min(min_y, y);
		max_y = max(max_y, y);
	}
	cout << (min_x - 1) << ',' << (min_y - 1) << '\n';
	cout << (max_x + 1) << ',' << (max_y + 1) << endl;

	return 0;
}