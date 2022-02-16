#include <bits/stdc++.h>

using namespace std;
constexpr int INF = 0x3f3f3f3f;

constexpr int MN = 2e5 + 5;
vector<int> adj[MN];
bool vis[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, m;
	cin >> n >> m;
	vector<pair<int, int>> edges(m);
	for (auto &[from, to] : edges) {
		cin >> from >> to;
		adj[from].push_back(to);
		adj[to].push_back(from);
	}

	int a, b, c, d;
	cin >> a >> b >> c >> d;
	if (find(adj[c].begin(), adj[c].end(), d) != adj[c].end()) {
		cout << "-1\n";
		return 0;
	}

	auto shortest_path_excluding = [&](int exclude) {
		memset(vis, false, sizeof(vis));
		queue<int> q;
		q.push(a);
		vis[a] = vis[exclude] = true;
		int dist = 1;
		while (!q.empty()) {
			int sz = q.size();
			while (sz--) {
				int node = q.front();
				q.pop();
				for (int nxt : adj[node]) {
					if (nxt == b) return dist;
					if (!vis[nxt]) {
						vis[nxt] = true;
						q.push(nxt);
					}
				}
			}
			dist++;
		}
		return INF;
	};

	int no_c = shortest_path_excluding(c);
	int no_d = shortest_path_excluding(d);
	if (min(no_c, no_d) == INF) {
		cout << "-1\n";
		return 0;
	}

	int use_two = no_c <= no_d ? c : d;
	cout << "2\n";
	for (auto [from, to] : edges) cout << (from == use_two || to == use_two ? 2 : 1) << '\n';
	return 0;
}