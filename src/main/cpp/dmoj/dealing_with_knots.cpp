#include <bits/stdc++.h>

using namespace std;

vector<int> adj[1001];
int a, b;
bool seen[1001];

bool go(int u) {
	for (int v : adj[u]) {
		if (v == b) return true;
		if (!seen[v]) {
			seen[v] = true;
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

	int n;
	cin >> n;
	while (n--) {
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
	}

	cin >> a >> b;
	seen[a] = true;
	cout << (go(a) ? "Tangled" : "Not Tangled") << '\n';
	return 0;
}