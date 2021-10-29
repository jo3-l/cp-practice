// Trie-based brute-force solution - O(n^2). Gets 10.5/15.
#include <bits/stdc++.h>

using namespace std;

int remap(char c) {
	if (c <= '9') return c - '0';
	return c - 'a' + 10;
}

// To save space, represent the tree as a 2d array where children[s][k] is the node pointed to by k from s.
int children[1'800'000][36]; // 1.8 million is about as large as we can fit within the memory limit.
int state_count = 1;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int t;
	cin >> t;
	while (t--) {
		memset(children, -1, sizeof(children));

		string s;
		cin >> s;
		int root = 1, cnt = 1;
		for (int i = 0; i < s.size(); i++) {
			int cur = root;
			for (int j = i; j < s.size(); j++) {
				int k = remap(s[j]);
				if (children[cur][k] == -1) {
					cnt++;
					children[cur][k] = ++state_count;
				}
				cur = children[cur][k];
			}
		}

		cout << cnt << '\n';
		state_count = 1;
	}

	return 0;
}