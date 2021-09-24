#include <bits/stdc++.h>

using namespace std;

unordered_map<int, double> best;
unordered_map<int, vector<pair<int, double>>> adj;

double solve(vector<vector<int>> &edges, vector<double> &success, int start,
	     int end) {
	adj.clear();
	for (int i = 0; i < edges.size(); i++) {
		vector<int> &edge = edges[i];
		adj[edge[0]].push_back({edge[1], success[i]});
		adj[edge[1]].push_back({edge[0], success[i]});
	}

	best.clear();
	best[start] = 1;
	priority_queue<pair<double, int>> pq;
	pq.push({1, start});
	while (!pq.empty()) {
		pair<double, int> p = pq.top();
		pq.pop();
		if (p.first != best[p.second]) continue;
		for (pair<int, double> edge : adj[p.second]) {
			double prob = p.first * edge.second;
			auto it = best.find(edge.first);
			if (it == best.end() || prob > it->second) {
				best[edge.first] = prob;
				pq.push({prob, edge.first});
			}
		}
	}
	return best[end];
}