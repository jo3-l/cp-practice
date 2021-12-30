#include <bits/stdc++.h>

using namespace std;

vector<int> adj[2001];
bool vis[2001];
int a, b;

bool go(int u) {
	for (int v : adj[u]) {
		if (v == b) return true;
		if (!vis[v]) {
			vis[v] = true;
			if (go(v)) return true;
		}
	}
	return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, m;
	cin >> n >> m >> a >> b;
	while (m--) {
		int u, v;
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}

	vis[a] = true;
	cout << (a == b || go(a) ? "GO SHAHIR!" : "NO SHAHIR!") << '\n';
	return 0;
}