#include <bits/stdc++.h>

using namespace std;

bool solve(vector<vector<int>> &graph) {
	unordered_set<int> seen;
	for (int b = 0; b < graph.size(); b++) {
		if (seen.count(b)) continue;
		deque<int> dq{b};
		vector<int> seen_at(graph.size(), -1);
		int lvl = 1;
		seen_at[b] = 0;
		while (!dq.empty()) {
			int sz = dq.size();
			while (sz--) {
				int v = dq.front();
				dq.pop_front();
				for (int u : graph[v]) {
					if (seen_at[u] == -1) {
						if (!seen.count(u)) {
							seen.insert(u);
							seen_at[u] = lvl;
							dq.push_back(u);
						}
					} else if ((lvl - seen_at[u]) & 1) {
						return true;
					}
				}
			}
			lvl++;
		}
		seen.insert(b);
	}
	return false;
}