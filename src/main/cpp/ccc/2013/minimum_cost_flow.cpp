// doesn't ever apply pipe enhancer, so 11/15 :(
#include <bits/stdc++.h>

using namespace std;

using ll = long long;

struct Pipe {
	int from, to;
	ll cost;
	bool orig_selected;
};

Pipe pipes[200'000];
int par[100'000];
int sz[100'000];

int find(int n) {
	if (n == par[n]) return n;
	return par[n] = find(par[n]);
}

bool unite(int a, int b) {
	a = find(a), b = find(b);
	if (a == b) return false;
	if (sz[a] > sz[b]) swap(a, b);
	sz[b] += sz[a];
	par[a] = b;
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, m;
	ll d;
	cin >> n >> m >> d;
	fill(sz, sz + n, 1);
	iota(par, par + n, 0);
	for (int i = 0; i < m; i++) {
		cin >> pipes[i].from >> pipes[i].to >> pipes[i].cost;
		pipes[i].from--, pipes[i].to--; // 0-based
		pipes[i].orig_selected = i < n - 1;
	}
	sort(pipes, pipes + m,
	     [](Pipe &a, Pipe &b) { return a.cost < b.cost || (a.cost == b.cost && a.orig_selected && !b.orig_selected); });
	int newly_selected = 0, reused = 0;
	for (int i = 0; i < m && newly_selected + reused < n - 1; i++) {
		auto &p = pipes[i];
		if (unite(p.from, p.to)) {
			if (p.orig_selected) reused++;
			else newly_selected++;
		}
	}
	int need_deactivation = n - reused - 1;
	int days = need_deactivation + newly_selected - min(need_deactivation, newly_selected);
	cout << days << '\n';
	return 0;
}