// 7/15 using Djikstra's; TLEs on the rest :/
#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 200'001;
int max_station, walkway_count, total_days;
vector<int> walkways[MN];
int station_mp[MN]; // station[n] is the current number of the nth station

int best[MN];

int solve() {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	for (int i = 1; i <= max_station; i++) {
		int s = station_mp[i];
		best[s] = i - 1;
		pq.push({s, i - 1});
	}

	while (!pq.empty()) {
		int station, cur_cost;
		tie(station, cur_cost) = pq.top();
		pq.pop();
		if (best[station] != cur_cost) continue;
		for (int to : walkways[station]) {
			int cost = cur_cost + 1;
			if (cost < best[to]) {
				best[to] = cost;
				pq.push({to, cost});
			}
		}
	}

	return best[max_station];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> max_station >> walkway_count >> total_days;
	for (int i = 0; i < walkway_count; i++) {
		int from, to;
		cin >> from >> to;
		walkways[from].push_back(to);
	}
	for (int i = 1; i <= max_station; i++) {
		cin >> station_mp[i];
	}
	for (int i = 0; i < total_days; i++) {
		int x, y;
		cin >> x >> y;
		swap(station_mp[x], station_mp[y]);
		cout << solve() << '\n';
	}

	return 0;
}
