#include <bits/stdc++.h>

using namespace std;

struct cell {
	int r, c;
};

constexpr int MAX_CELL_VALUE = 1'000'000;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int m, n;
	cin >> m >> n;
	vector<vector<int>> cells(m + 1, vector<int>(n + 1));
	array<vector<cell>, MAX_CELL_VALUE + 1> adj{};
	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> cells[i][j];
			adj[i * j].push_back({i, j});
		}
	}

	auto can_escape = [&] {
		if (m == 1 && n == 1) return true;

		array<bool, MAX_CELL_VALUE + 1> seen{};
		queue<cell> q;
		q.push({1, 1});
		seen[cells[1][1]] = true;
		while (!q.empty()) {
			auto [i, j] = q.front();
			q.pop();
			for (auto nxt : adj[cells[i][j]]) {
				int val = cells[nxt.r][nxt.c];
				if (val == m * n) return true;
				if (!seen[val]) {
					seen[val] = true;
					q.push(nxt);
				}
			}
		}
		return seen[m * n];
	};
	cout << (can_escape() ? "yes" : "no") << '\n';
}
