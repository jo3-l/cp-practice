#include <bits/stdc++.h>

using namespace std;

template <class T>
using min_pq = priority_queue<T, vector<T>, greater<T>>;

constexpr int INF = numeric_limits<int>::max();

struct route {
	int dst, dur, hull_dmg;
};

struct state {
	int island, time, hull_left;

	bool operator<(state const& other) const {
		return time < other.time;
	}
	bool operator>(state const& other) const {
		return time > other.time;
	}
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int k, n, m;
	cin >> k >> n >> m;
	vector<vector<route>> adj(n + 1);
	while (m--) {
		int a, b, t, h;
		cin >> a >> b >> t >> h;
		adj[a].push_back({b, t, h});
		adj[b].push_back({a, t, h});
	}

	int initial, target;
	cin >> initial >> target;

	// best[i, j] is min. time to travel to i with j cm of hull left
	vector<vector<int>> best(n + 1, vector<int>(k + 1, INF));
	min_pq<state> pq;
	pq.push({initial, 0, k});
	best[initial][k] = 0;
	while (!pq.empty()) {
		auto [island, time, hull_remaining] = pq.top();
		pq.pop();

		assert(time >= best[island][hull_remaining]);
		if (time > best[island][hull_remaining]) continue;

		for (auto& route : adj[island]) {
			int new_hull_thickness = hull_remaining - route.hull_dmg;
			if (new_hull_thickness <= 0) continue;
			int time_to_dst = time + route.dur;
			if (time_to_dst < best[route.dst][new_hull_thickness]) {
				best[route.dst][new_hull_thickness] = time_to_dst;
				pq.push({route.dst, time_to_dst, new_hull_thickness});
			}
		}
	}

	int t = *min_element(best[target].begin(), best[target].end());
	if (t == INF)
		cout << "-1\n";
	else
		cout << t << '\n';
}