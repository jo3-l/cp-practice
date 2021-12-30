#include <bits/stdc++.h>

using namespace std;
using ll = long long;

template <typename T> using min_pq = priority_queue<T, vector<T>, greater<T>>;

ll best[100'001];
vector<pair<int, int>> adj[100'001]; // {to, cost}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, m;
	cin >> n >> m;
	while (m--) {
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back({b, c});
	}

	memset(best, 0x3f, sizeof(best));
	best[1] = 0;
	min_pq<pair<int, ll>> pq;
	pq.push({1, 0});
	while (!pq.empty()) {
		int to;
		ll cost;
		tie(to, cost) = pq.top();
		pq.pop();
		if (cost != best[to]) continue;
		for (auto e : adj[to]) {
			if (cost + e.second < best[e.first]) {
				best[e.first] = cost + e.second;
				pq.push({e.first, cost + e.second});
			}
		}
	}

	for (int i = 1; i <= n; i++) cout << best[i] << ' ';
	cout << '\n';

	return 0;
}