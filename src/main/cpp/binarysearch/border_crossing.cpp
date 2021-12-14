#include <bits/stdc++.h>

using namespace std;

template <typename T> using min_pq = priority_queue<T, vector<T>, greater<T>>;

constexpr int INF = 0x3f3f3f3f;

vector<int> solve(vector<vector<int>> &roads, vector<vector<int>> &countries, int start, int end) {
	unordered_map<int, pair<int, int>> best;	// {hops, cost}
	unordered_map<int, vector<pair<int, int>>> adj; // {to, cost}
	for (auto &road : roads) {
		adj[road[0]].push_back({road[1], road[2]});
		best[road[0]] = {INF, INF};
		best[road[1]] = {INF, INF};
	}
	unordered_map<int, int> country;
	for (int i = 0; i < countries.size(); i++) {
		for (int c : countries[i]) country[c] = i;
	}

	min_pq<tuple<int, int, int>> pq; // {to, hops, cost}
	pq.push({start, 0, 0});
	while (!pq.empty()) {
		int u, hops, cost;
		tie(u, hops, cost) = pq.top();
		pq.pop();
		for (auto e : adj[u]) {
			int to, e_cost;
			tie(to, e_cost) = e;
			pair<int, int> nxt{hops + (country[to] != country[u]), cost + e_cost};
			if (nxt < best[to]) {
				best[to] = nxt;
				pq.push({to, nxt.first, nxt.second});
			}
		}
	}
	pair<int, int> ans = best[end];
	return {ans.first, ans.second};
}