#include <bits/stdc++.h>

using namespace std;

template <class Fun> class y_combinator_result {
	Fun fun_;

public:
	template <class T> explicit y_combinator_result(T &&fun) : fun_(std::forward<T>(fun)) {}
	template <class... Args> decltype(auto) operator()(Args &&...args) { return fun_(std::ref(*this), std::forward<Args>(args)...); }
};

template <class Fun> decltype(auto) y_combinator(Fun &&fun) { return y_combinator_result<std::decay_t<Fun>>(std::forward<Fun>(fun)); }

bool solve(int n, vector<vector<int>> &enemies) {
	unordered_map<int, vector<int>> adj;
	for (auto &e : enemies) {
		adj[e[0]].push_back(e[1]);
		adj[e[1]].push_back(e[0]);
	}
	vector<int> clr(n, -1);
	auto check = y_combinator([&](auto check, int v) -> bool {
		if (clr[v] == -1) clr[v] = 0;
		for (int u : adj[v]) {
			if (clr[u] == -1) {
				clr[u] = clr[v] ^ 1;
				if (!check(u)) return false;
			} else if (clr[u] != (clr[v] ^ 1)) {
				return false;
			}
		}
		return true;
	});
	for (int i = 0; i < n; i++) {
		if (!check(i)) {
			return false;
		}
	}
	return true;
}