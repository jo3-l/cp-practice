#include <bits/stdc++.h>

using namespace std;

int par[100'005];
int sz[100'005];

int find(int x) {
	if (x == par[x]) return x;
	return par[x] = find(par[x]);
}

void unite(int a, int b) {
	a = find(a), b = find(b);
	if (a == b) return;
	if (sz[a] > sz[b]) swap(a, b);
	sz[b] += sz[a];
	par[a] = b;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, q;
	cin >> n >> q;
	iota(begin(par) + 1, begin(par) + n + 1, 1);
	fill(begin(sz) + 1, begin(sz) + n + 1, 1);
	while (q--) {
		int t;
		cin >> t;
		if (t == 1) {
			int u, v;
			cin >> u >> v;
			unite(u, v);
		} else {
			int x;
			cin >> x;
			cout << sz[find(x)] << '\n';
		}
	}

	return 0;
}