#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 500'001;

int par[MN];
int sz[MN];

struct Op {
	int u, v;
	int u_sz, v_sz;

	void rollback() {
		par[u] = u;
		par[v] = v;
		sz[u] = u_sz;
		sz[v] = v_sz;
	}
};

stack<Op> ops;

void Init(int n) {
	iota(begin(par), end(par), 0);
	fill(begin(sz), end(sz), 1);
}

int Find(int u) {
	if (u == par[u]) return u;
	return Find(par[u]);
}

void AddEdge(int a, int b) {
	a = Find(a);
	b = Find(b);
	if (sz[a] > sz[b]) swap(a, b);
	ops.push({a, b, sz[a], sz[b]});
	if (a != b) {
		par[a] = b;
		sz[b] += sz[a];
	}
}

void RemoveLastEdge() {
	assert(!ops.empty());
	ops.top().rollback();
	ops.pop();
}

int GetSize(int U) { return sz[Find(U)]; }
