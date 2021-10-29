#include <bits/stdc++.h>

using namespace std;

struct Road {
	int x, y, w;
};

constexpr int MR = 100'000;
Road roads[MR];

constexpr int MC = 10'001;
bool is_dest[MC];
int par[MC];
int sz[MC];

int find(int n) {
	if (par[n] == n) return n;
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

	int c, r, d;
	cin >> c >> r >> d;
	for (int i = 0; i < r; i++) cin >> roads[i].x >> roads[i].y >> roads[i].w;
	for (int i = 0; i < d; i++) {
		int n;
		cin >> n;
		is_dest[n] = true;
	}

	iota(begin(par), begin(par) + c + 1, 0);
	memset(sz, sizeof(int) * (c + 1), 1);

	sort(begin(roads), begin(roads) + r, [](Road &a, Road &b) { return a.w > b.w; });
	int remaining = d;
	int max_weight = -1;
	for (int i = 0; i < r && remaining; i++) {
		if (unite(roads[i].x, roads[i].y)) {
			remaining -= is_dest[roads[i].x];
			remaining -= is_dest[roads[i].y];
			is_dest[roads[i].x] = is_dest[roads[i].y] = false;
			max_weight = roads[i].w;
		}
	}

	cout << max_weight << '\n';
	return 0;
}