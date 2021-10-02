#include <bits/stdc++.h>

using namespace std;

struct Edge {
	int travel_time;
	int hull_cost;
	int to;
};

constexpr int MN = 2001;
vector<Edge> islands[MN];

constexpr int MK = 201;
int best[MK][MN];

int main() {
	int hull, island_cnt, routes;
	cin >> hull >> island_cnt >> routes;
	while (routes--) {
		int a, b, t, h;
		cin >> a >> b >> t >> h;
		islands[a].push_back({t, h, b});
		islands[b].push_back({t, h, a});
	}
	int start, target;
	cin >> start >> target;

	using E = tuple<int, int, int>;
	priority_queue<E, vector<E>, greater<E>> pq;
	pq.push(make_tuple(start, 0, hull));

	memset(best, 0x3f, sizeof(best));
	best[hull][start] = 0;

	int ans = 0x3f3f3f3f;
	while (!pq.empty()) {
		int cur, cost, remaining_hull;
		tie(cur, cost, remaining_hull) = pq.top();
		if (cur == target) ans = min(ans, cost);
		pq.pop();
		if (best[remaining_hull][cur] != cost) continue;
		for (auto &e : islands[cur]) {
			int next_hull = remaining_hull - e.hull_cost;
			if (next_hull <= 0) continue;
			int next_cost = cost + e.travel_time;
			if (best[next_hull][e.to] > next_cost) {
				best[next_hull][e.to] = next_cost;
				pq.push(make_tuple(e.to, next_cost, next_hull));
			}
		}
	}
	cout << (ans == 0x3f3f3f3f ? -1 : ans) << '\n';
	return 0;
}
