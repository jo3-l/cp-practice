#include <bits/stdc++.h>

using namespace std;

int adj[26]; // bitset

int dfs(int p, int vis) {
	for (int i = 0; i < 26; i++) {
		int dest = 1 << i;
		if (adj[p] & ~vis & dest) vis |= dfs(i, vis |= dest);
	}
	return vis;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	char a, b;
	for (cin >> a >> b; a != '*'; cin >> a >> b) {
		adj[a - 'A'] |= 1 << (b - 'A');
		adj[b - 'A'] |= 1 << (a - 'A');
	}

	int cnt = 0;
	for (int i = 0; i < 26; i++) {
		for (int j = i + 1; j < 26; j++) {
			if (adj[i] & (1 << j)) {
				adj[i] &= ~(1 << j);
				adj[j] &= ~(1 << i);
				if (!(dfs(0, 1 << 0) & (1 << 1))) {
					cout << (char)(i + 'A') << (char)(j + 'A') << '\n';
					cnt++;
				}
				adj[i] |= 1 << j;
				adj[j] |= 1 << i;
			}
		}
	}
	cout << "There are " << cnt << " disconnecting roads." << '\n';
	return 0;
}
