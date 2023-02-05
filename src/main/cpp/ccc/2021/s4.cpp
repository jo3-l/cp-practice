#include <bits/stdc++.h>

using namespace std;

constexpr int INF = 0x3f3f3f3f;

struct station_swap {
	int x, y;
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, w, d;
	cin >> n >> w >> d;

	vector<vector<int>> walkways_to(n + 1);
	for (int i = 0; i < w; i++) {
		int src, dst;
		cin >> src >> dst;
		walkways_to[dst].push_back(src);
	}

	vector<int> time_by_bus(n + 1);
	vector<int> route(n + 1);
	for (int i = 1; i <= n; i++) {
		cin >> route[i];
		time_by_bus[route[i]] = i - 1;
	}

	vector<station_swap> swaps(d);
	for (auto& s : swaps) cin >> s.x >> s.y;

	vector<int> time_to_end(n + 1, INF);
	time_to_end[n] = 0;

	queue<int> q;
	q.push(n);
	while (!q.empty()) {
		int cur = q.front();
		q.pop();
		for (int prev : walkways_to[cur]) {
			if (time_to_end[cur] + 1 < time_to_end[prev]) {
				time_to_end[prev] = time_to_end[cur] + 1;
				q.push(prev);
			}
		}
	}

	multiset<int> best;
	for (int i = 1; i <= n; i++) {
		best.insert(time_by_bus[i] + time_to_end[i]);
	}
	for (auto& s : swaps) {
		best.erase(best.find(time_by_bus[route[s.x]] + time_to_end[route[s.x]]));
		best.erase(best.find(time_by_bus[route[s.y]] + time_to_end[route[s.y]]));
		swap(time_by_bus[route[s.x]], time_by_bus[route[s.y]]);
		swap(route[s.x], route[s.y]);
		best.insert(time_by_bus[route[s.x]] + time_to_end[route[s.x]]);
		best.insert(time_by_bus[route[s.y]] + time_to_end[route[s.y]]);
		cout << *best.begin() << '\n';
	}
}
