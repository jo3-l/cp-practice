#include <bits/stdc++.h>

using namespace std;

queue<int> targets[2001];
int last_target[2001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, t;
	cin >> n >> t;
	for (int i = 1; i <= n; i++) {
		int v;
		cin >> v;
		targets[i].push(v);
	}
	for (int rnd = 1; rnd <= t; rnd++) {
		vector<pair<int, int>> deferred;
		for (int i = 1; i <= n; i++) {
			if (!targets[i].empty()) {
				last_target[i] = targets[i].front();
				targets[i].pop();
				deferred.push_back({last_target[i], i});
			}
		}

		for (auto &p : deferred) targets[p.first].push(p.second);
	}

	for (int i = 1; i <= n; i++) {
		if (i > 1) cout << ' ';
		cout << last_target[i];
	}
	cout << '\n';
	return 0;
}