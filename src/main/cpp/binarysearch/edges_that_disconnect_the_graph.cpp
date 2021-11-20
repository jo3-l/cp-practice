#include <bits/stdc++.h>

using namespace std;

template <class Fun> class y_combinator_result {
	Fun fun_;

public:
	template <class T> explicit y_combinator_result(T &&fun) : fun_(std::forward<T>(fun)) {}
	template <class... Args> decltype(auto) operator()(Args &&...args) { return fun_(std::ref(*this), std::forward<Args>(args)...); }
};

template <class Fun> decltype(auto) y_combinator(Fun &&fun) { return y_combinator_result<std::decay_t<Fun>>(std::forward<Fun>(fun)); }

bool vis[250];
int seen_at[250];
int lo_link[250];

int solve(vector<vector<int>> &graph) {
	memset(vis, false, sizeof(vis));
	memset(seen_at, -1, sizeof(seen_at));
	memset(lo_link, -1, sizeof(lo_link));
	int ctr = 0, bridges = 0;
	auto dfs = y_combinator([&](auto dfs, int node, int par = -1) -> void {
		vis[node] = true;
		seen_at[node] = lo_link[node] = ctr++;
		for (int to : graph[node]) {
			if (to == par) continue;
			if (vis[to]) {
				lo_link[node] = min(lo_link[node], seen_at[to]);
			} else {
				dfs(to, node);
				lo_link[node] = min(lo_link[node], lo_link[to]);
				if (lo_link[to] > seen_at[node]) bridges++;
			}
		}
	});
	for (int i = 0; i < graph.size(); i++) {
		if (!vis[i]) dfs(i);
	}
	return bridges;
}