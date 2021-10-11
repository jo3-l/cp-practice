#include <bits/stdc++.h>

using namespace std;

struct Route {
	int to, cost;
};

constexpr int INF = 0x3f3f3f3f;
constexpr int MN = 5000;
vector<Route> routes[MN];
int best[MN];
int pencil_cost[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	memset(best, 0x3f, sizeof(best));
	memset(pencil_cost, -1, sizeof(pencil_cost));

	int n, t;
	cin >> n >> t;
	while (t--) {
		int x, y, cost;
		cin >> x >> y >> cost;
		routes[x].push_back({y, cost});
		routes[y].push_back({x, cost});
	}

	int k;
	cin >> k;
	while (k--) {
		int c, cost;
		cin >> c >> cost;
		pencil_cost[c] = cost;
	}

	int d;
	cin >> d;
	best[d] = 0;
	int ans = pencil_cost[d] == -1 ? INF : pencil_cost[d];
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({d, 0});
	while (!pq.empty()) {
		int city, cost;
		tie(city, cost) = pq.top();
		pq.pop();
		if (best[city] != cost) continue;
		for (Route r : routes[city]) {
			int next_cost = cost + r.cost;
			if (next_cost < best[r.to]) {
				best[r.to] = next_cost;
				pq.push({r.to, next_cost});
				if (pencil_cost[r.to] != -1) ans = min(ans, pencil_cost[r.to] + next_cost);
			}
		}
	}

	cout << ans << '\n';
	return 0;
}