#include <bits/stdc++.h>

using namespace std;

int square(int x) {
	return x * x;
}

int par[755];
int sz[755];

int find(int n) {
	if (n == par[n]) return n;
	return par[n] = find(par[n]);
}

bool unite(int a, int b) {
	a = find(a), b = find(b);
	if (a == b) return false;
	if (sz[a] > sz[b]) swap(a, b);
	par[a] = b;
	sz[b] += sz[a];
	return true;
}

pair<int, int> buildings[751];

struct Edge {
	int x, y;
	double len;
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	fill(sz + 1, sz + n + 1, 1);
	iota(par + 1, par + n + 1, 1);

	for (int i = 1; i <= n; i++) cin >> buildings[i].first >> buildings[i].second;
	vector<Edge> edges;
	for (int i = 1; i < n; i++) {
		for (int j = i + 1; j <= n; j++) {
			auto [x1, y1] = buildings[i];
			auto [x2, y2] = buildings[j];
			edges.push_back({i, j, sqrt(double(square(x1 - x2) + square(y1 - y2)))});
		}
	}

	sort(edges.begin(), edges.end(), [](Edge &a, Edge &b) { return a.len < b.len; });
	int m;
	cin >> m;
	while (m--) {
		int a, b;
		cin >> a >> b;
		unite(a, b);
	}

	double total_cost = 0;
	vector<Edge> used;
	for (Edge &edge : edges) {
		if (unite(edge.x, edge.y)) {
			used.push_back(edge);
			total_cost += edge.len;
			if (--n == 0) break;
		}
	}

	cout << fixed << setprecision(2) << total_cost << '\n';
	for (Edge &edge : used) cout << edge.x << ' ' << edge.y << '\n';
	return 0;
}