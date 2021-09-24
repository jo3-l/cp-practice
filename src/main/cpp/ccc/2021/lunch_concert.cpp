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

class Friend {
      public:
	int pos;
	int walking_speed;
	int max_dist;
};

const int MAX_N = 2e5;
Friend friends[MAX_N];

int n;

i64 cmp_walking_time(int pos) {
	i64 total_time = 0;
	for (int i = 0; i < n; i++) {
		Friend &f = friends[i];
		if (f.pos < pos) {
			int min_ok_pos = pos - f.max_dist;
			if (f.pos >= min_ok_pos) continue;
			total_time +=
			    (min_ok_pos - f.pos) * (i64)f.walking_speed;
		} else {
			int max_ok_pos = pos + f.max_dist;
			if (f.pos <= max_ok_pos) continue;
			total_time +=
			    (f.pos - max_ok_pos) * (i64)f.walking_speed;
		}
	}
	return total_time;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n;

	// Graph an example on some paper. If we let f(d) be the cost for
	// everyone to get to point d, then the graph of f looks like a valley.
	// (This can actually be proven mathematically.) As such, we can binary
	// search for the lowest point in the valley.
	int min_pos = INT_MAX, max_pos = INT_MIN;
	for (int i = 0; i < n; i++) {
		cin >> friends[i].pos >> friends[i].walking_speed >>
		    friends[i].max_dist;
		min_pos = min(min_pos, friends[i].pos);
		max_pos = max(max_pos, friends[i].pos);
	}

	int lo = min_pos, hi = max_pos;
	while (lo < hi) {
		int mid = (lo + hi + 1) >> 1;
		i64 prev_time = cmp_walking_time(mid - 1);
		i64 cur_time = cmp_walking_time(mid);
		if (prev_time > cur_time)
			lo = mid;
		else
			hi = mid - 1;
	}
	cout << cmp_walking_time(lo) << endl;

	return 0;
}