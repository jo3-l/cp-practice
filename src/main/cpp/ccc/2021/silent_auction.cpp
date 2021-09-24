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

	int n;
	cin >> n;

	string best_bidder;
	int best_bid = -1;
	while (n--) {
		string name;
		int bid;
		cin >> name >> bid;
		if (bid > best_bid) {
			best_bid = bid;
			best_bidder = name;
		}
	}

	cout << best_bidder << endl;

	return 0;
}