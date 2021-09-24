#include <bits/stdc++.h>

#define dbg(x) cout << #x << " = " << x << '\n';
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

	string s;
	char last_dir = 'l';
	while (cin >> s) {
		if (s == "99999") break;
		int sum = s[0] - '0' + s[1] - '0';
		char dir;
		if (sum == 0)
			dir = last_dir;
		else if (sum & 1)
			dir = 'l';
		else
			dir = 'r';
		last_dir = dir;

		int steps = (s[2] - '0') * 100 + (s[3] - '0') * 10 + s[4] - '0';
		cout << (dir == 'r' ? "right" : "left") << ' ' << steps << '\n';
	}

	return 0;
}