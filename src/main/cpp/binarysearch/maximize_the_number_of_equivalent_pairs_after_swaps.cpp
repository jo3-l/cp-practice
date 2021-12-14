#include <bits/stdc++.h>

using namespace std;

int par[100'000];
int sz[100'000];

int find(int n) {
	if (n == par[n]) return n;
	return par[n] = find(par[n]);
}

bool unite(int a, int b) {
	a = find(a);
	b = find(b);
	if (a == b) return false;
	if (sz[a] > sz[b]) swap(a, b);
	sz[b] += sz[a];
	par[a] = b;
	return true;
}

int solve(vector<int> &A, vector<int> &B, vector<vector<int>> &C) {
	memset(par, 0, sizeof(par));
	memset(sz, 0, sizeof(par));
	iota(par, par + A.size(), 0);
	for (auto &c : C) unite(c[0], c[1]);
	unordered_map<int, vector<int>> mp;
	for (int i = 0; i < A.size(); i++) {
		if (A[i] != B[i]) mp[A[i]].push_back(i);
	}
	int good = 0;
	for (int i = 0; i < A.size(); i++) {
		if (A[i] == B[i]) {
			good++;
		} else {
			auto it = mp.find(B[i]); // possible positions to swap with
			if (it != mp.end()) {
				auto &xs = it->second;
				int k = xs.size();
				while (k--) {
					int j = xs[k];
					if (find(i) == find(j)) {
						swap(xs[k], xs.back());
						xs.pop_back();
						good++;
						break;
					}
				}
			}
		}
	}
	return good;
}