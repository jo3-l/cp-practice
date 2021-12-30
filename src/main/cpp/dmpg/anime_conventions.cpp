#include <bits/stdc++.h>

using namespace std;

int par[200'001];
int sz[200'001];

int find(int n) {
	if (n == par[n]) return n;
	return par[n] = find(par[n]);
}

void unite(int a, int b) {
	a = find(a);
	b = find(b);
	if (a == b) return;
	if (sz[a] > sz[b]) swap(a, b);
	sz[b] += sz[a];
	par[a] = b;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	iota(begin(par), end(par), 0);
	fill(begin(sz), end(sz), 1);

	int n, q;
	cin >> n >> q;
	while (q--) {
		char t;
		int x, y;
		cin >> t >> x >> y;
		if (t == 'A') unite(x, y);
		else cout << (find(x) == find(y) ? 'Y' : 'N') << '\n';
	}

	return 0;
}