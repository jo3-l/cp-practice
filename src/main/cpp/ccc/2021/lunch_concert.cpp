#include <bits/stdc++.h>

using ll = long long;
using namespace std;

struct Friend {
	int pos;
	int walking_speed;
	int max_dist;
};

constexpr int MN = 200'000;
Friend friends[MN];

int n;

ll cmp_walking_time(int pos) {
	ll total_time = 0;
	for (int i = 0; i < n; i++) {
		Friend &f = friends[i];
		if (f.pos < pos) {
			int min_ok_pos = pos - f.max_dist;
			if (f.pos >= min_ok_pos) continue;
			total_time += (min_ok_pos - f.pos) * (ll)f.walking_speed;
		} else {
			int max_ok_pos = pos + f.max_dist;
			if (f.pos <= max_ok_pos) continue;
			total_time += (f.pos - max_ok_pos) * (ll)f.walking_speed;
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
		cin >> friends[i].pos >> friends[i].walking_speed >> friends[i].max_dist;
		min_pos = min(min_pos, friends[i].pos);
		max_pos = max(max_pos, friends[i].pos);
	}

	int lo = min_pos, hi = max_pos;
	while (lo < hi) {
		int mid = (lo + hi + 1) >> 1;
		ll prev_time = cmp_walking_time(mid - 1);
		ll cur_time = cmp_walking_time(mid);
		if (prev_time > cur_time)
			lo = mid;
		else
			hi = mid - 1;
	}
	cout << cmp_walking_time(lo) << endl;

	return 0;
}