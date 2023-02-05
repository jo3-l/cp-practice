#include <bits/stdc++.h>

using namespace std;

template <class Fun>
class y_combinator_result {
	Fun fun_;

public:
	template <class T>
	explicit y_combinator_result(T&& fun) : fun_(std::forward<T>(fun)) {}
	template <class... Args>
	decltype(auto) operator()(Args&&... args) {
		return fun_(std::ref(*this), std::forward<Args>(args)...);
	}
};

template <class Fun>
decltype(auto) y_combinator(Fun&& fun) {
	return y_combinator_result<std::decay_t<Fun>>(std::forward<Fun>(fun));
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	vector<vector<int>> options(n + 1);
	for (int p = 1; p <= n; p++) {
		int m;
		cin >> m;
		options[p].resize(m);
		for (auto& o : options[p]) cin >> o;
	}

	{
		vector<bool> reachable(n + 1);
		auto dfs = y_combinator([&](auto dfs, int p) {
			if (reachable[p]) return;
			reachable[p] = true;
			for (int nxt : options[p]) dfs(nxt);
		});
		dfs(1);
		cout << (count(reachable.begin(), reachable.end(), true) == n ? 'Y' : 'N') << '\n';
	}

	queue<int> q;
	vector<bool> seen(n + 1);
	q.push(1);
	seen[1] = true;
	int path_len = 1;
	while (!q.empty()) {
		int k = q.size();
		while (k--) {
			int p = q.front();
			q.pop();
			if (options[p].empty()) goto done;
			for (int nxt : options[p]) {
				if (!seen[nxt]) {
					seen[nxt] = true;
					q.push(nxt);
				}
			}
		}
		path_len++;
	}

done:
	cout << path_len << '\n';
}