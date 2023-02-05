#include <bits/stdc++.h>

using namespace std;

struct friend_ {
	int pos, time_per_m, radius;

	int left_bound() {
		return pos - radius;
	}
	int right_bound() {
		return pos + radius;
	}
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	vector<friend_> friends(n);
	for (auto& f : friends) cin >> f.pos >> f.time_per_m >> f.radius;

	auto calc_time = [&](int pos) {
		int64_t t = 0;
		for (auto& f : friends) {
			if (pos < f.left_bound())
				t += int64_t(f.left_bound() - pos) * f.time_per_m;
			else if (pos > f.right_bound())
				t += int64_t(pos - f.right_bound()) * f.time_per_m;
		}
		return t;
	};

	auto [leftmost, rightmost] = minmax_element(friends.begin(), friends.end(), [](friend_& a, friend_& b) { return a.pos < b.pos; });
	int lo = leftmost->pos, hi = rightmost->pos;
	while (lo < hi) {
		int mid = (lo + hi) / 2;
		if (calc_time(mid) <= calc_time(mid + 1))
			hi = mid;
		else
			lo = mid + 1;
	}
	cout << calc_time(lo) << '\n';
}
