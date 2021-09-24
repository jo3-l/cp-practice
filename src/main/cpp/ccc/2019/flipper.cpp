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
		static const ull R =
		    chrono::steady_clock::now().time_since_epoch().count();
		return hash<T1>{}(p.first ^ R ^ (p.first >> 16)) ^
		       (hash<T2>{}(p.second ^ R ^ (p.first >> 16)) >> 1);
	}
};

const char *combo[2][2] = {
    {"1 2\n3 4", "2 1\n4 3"},
    {"3 4\n1 2", "4 3\n2 1"},
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int h = 0, v = 0;
	string flips;
	cin >> flips;
	for (char c : flips) {
		if (c == 'H')
			h ^= 1;
		else
			v ^= 1;
	}
	cout << combo[h][v] << endl;

	return 0;
}