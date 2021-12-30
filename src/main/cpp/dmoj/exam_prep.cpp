#include <bits/stdc++.h>

using namespace std;
using ll = long long;

constexpr int MN = 1'000'001;

int par[MN], sz[MN];
ll pages[MN];

int find(int n) {
	if (n == par[n]) return n;
	return par[n] = find(par[n]);
}

void unite(int a, int b) {
	a = find(a);
	b = find(b);
	if (a == b) return;
	if (sz[a] > sz[b]) swap(a, b);
	pages[b] += pages[a];
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
	for (int i = 1; i <= n; i++) cin >> pages[i];
	while (q--) {
		int t, a;
		cin >> t >> a;
		if (t == 1) {
			int b;
			cin >> b;
			unite(a, b);
		} else if (t == 2) {
			cout << sz[find(a)] << '\n';
		} else {
			cout << pages[find(a)] << '\n';
		}
	}

	return 0;
}