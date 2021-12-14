#include <bits/stdc++.h>

using namespace std;

template <class Fun> class y_combinator_result {
	Fun fun_;

public:
	template <class T> explicit y_combinator_result(T &&fun) : fun_(std::forward<T>(fun)) {}
	template <class... Args> decltype(auto) operator()(Args &&...args) { return fun_(std::ref(*this), std::forward<Args>(args)...); }
};

template <class Fun> decltype(auto) y_combinator(Fun &&fun) { return y_combinator_result<std::decay_t<Fun>>(std::forward<Fun>(fun)); }

bool solve(vector<vector<int>>& adj) {
    int n = adj.size();
    vector<int> clr(n, -1);
    auto check = y_combinator([&](auto check, int u) -> bool {
        if (clr[u] == -1) clr[u] = 0;
        for (int v : adj[u]) {
            if (clr[v] == -1) {
                clr[v] = clr[u] ^ 1;
                if (!check(v)) return false;
            } else if (clr[v] != (clr[u] ^ 1)) {
                return false;
            }
        }
        return true;
    });
    for (int i = 0; i < n; i++) if (!check(i)) return false;
    return true;
}