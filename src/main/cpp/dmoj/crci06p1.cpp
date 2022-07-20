#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, e;
	cin >> n >> e;
	vector<uint64_t> songs(n + 1);
	uint64_t all_songs = 0;
	for (int i = 0; i < e; i++) {
		int k;
		cin >> k;
		bool has_bard = false;
		vector<int> villagers(k);
		for (int& x : villagers) {
			cin >> x;
			has_bard |= x == 1;
		}
		if (has_bard) {
			for (int v : villagers) songs[v] |= 1ULL << i;
			all_songs |= 1ULL << i;
		} else {
			uint64_t all_known = 0;
			for (int v : villagers) all_known |= songs[v];
			for (int v : villagers) songs[v] |= all_known;
		}
	}

	for (int i = 1; i <= n; i++) {
		if (songs[i] == all_songs) cout << i << '\n';
	}

	return 0;
}