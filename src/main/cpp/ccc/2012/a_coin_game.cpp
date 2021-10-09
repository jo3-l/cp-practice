#include <bits/stdc++.h>

using namespace std;
using Lineup = vector<vector<int>>;

struct LineupHash {
	size_t operator()(const Lineup &lineup) const {
		size_t lhash = 0;
		for (const vector<int> &s : lineup) {
			size_t vhash = 0;
			for (int v : s) {
				size_t vh = hash<int>{}(v);
				vhash = vhash * 31 + (vh ^ (vh >> 2));
			}

			lhash = lhash * 31 + (vhash ^ (vhash >> 3));
		}
		return lhash;
	}
};

bool is_strictly_increasing(Lineup &lineup) {
	int prev = -1;
	for (vector<int> &s : lineup) {
		if (s.size() != 1 || s.back() <= prev) return false;
		prev = s.back();
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	Lineup initial_lineup;
	deque<Lineup> dq;
	unordered_set<Lineup, LineupHash> seen;
	int n;
	for (cin >> n; n != 0; cin >> n) {
		dq.clear();
		seen.clear();
		initial_lineup.assign(n, vector<int>());
		for (int i = 0; i < n; i++) {
			int j;
			cin >> j;
			initial_lineup[i].push_back(j);
		}

		if (is_strictly_increasing(initial_lineup)) {
			cout << 0 << '\n';
			continue;
		}

		dq.push_back(initial_lineup);
		seen.insert(initial_lineup);
		int moves = 1;
		while (!dq.empty()) {
			int sz = dq.size();
			while (sz--) {
				Lineup l = dq.front();
				dq.pop_front();
				for (int i = 0; i < n; i++) {
					if (l[i].empty()) continue;
					int v = l[i].back();
					auto try_move_to = [&](int to) {
						if (to >= 0 && to < n && (l[to].empty() || l[to].back() >= v)) {
							Lineup copy = l;
							copy[i].pop_back();
							copy[to].push_back(v);
							if (is_strictly_increasing(copy)) return true;
							if (!seen.count(copy)) {
								seen.insert(copy);
								dq.push_back(copy);
							}
						}
						return false;
					};

					if (try_move_to(i + 1) || try_move_to(i - 1)) goto possible;
				}
			}

			moves++;
		}

		cout << "IMPOSSIBLE" << '\n';
		continue;

	possible:
		cout << moves << '\n';
	}

	return 0;
}