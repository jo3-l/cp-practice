#include <bits/stdc++.h>

using namespace std;

vector<int> adj[100'005];
int par[100'005];
bool seen[100'005];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, m;
	cin >> n >> m;
	while (m--) {
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}

	deque<int> dq{1};
	seen[1] = true;
	int step = 1;
	while (!dq.empty()) {
		int sz = dq.size();
		while (sz--) {
			int u = dq.front();
			dq.pop_front();
			for (int v : adj[u]) {
				if (v == n) {
					par[v] = u;
					goto done;
				}
				if (!seen[v]) {
					seen[v] = true;
					par[v] = u;
					dq.push_back(v);
				}
			}
		}
		step++;
	}

	cout << "IMPOSSIBLE" << '\n';
	return 0;

done:
	cout << step + 1 << '\n';
	vector<int> path;
	path.reserve(step);
	for (int v = n; v != 1; v = par[v]) path.push_back(v);
	path.push_back(1);
	for (auto it = path.rbegin(); it != path.rend(); ++it) {
		if (it != path.rbegin()) cout << ' ';
		cout << *it;
	}
	cout << '\n';
	return 0;
}