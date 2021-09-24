#include <bits/stdc++.h>

using namespace std;

const int MN = 1e6 + 1;
int used[MN];
int parent[MN];
int size[MN];

int find(int n) {
	if (parent[n] == n) return n;
	return parent[n] = find(parent[n]);
}

void unite(int a, int b) {
	a = find(a);
	b = find(b);
	if (a == b) return;
	if (size[a] > size[b]) swap(a, b);
	size[b] += size[a];
	parent[a] = b;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, m;
	cin >> n >> m;
	iota(begin(parent), end(parent), 0);
	memset(size, 1, sizeof(size));
	int j = 0;
	for (int i = 0; i < m && j != n - 1; i++) {
		int from, to;
		cin >> from >> to;
		if (find(from) != find(to)) {
			used[j++] = i + 1;
			unite(from, to);
		}
	}
	if (j != n - 1) {
		cout << "Disconnected Graph" << '\n';
	} else {
		for (int i = 0; i < n - 1; i++)
			cout << used[i] << '\n';
	}

	return 0;
}