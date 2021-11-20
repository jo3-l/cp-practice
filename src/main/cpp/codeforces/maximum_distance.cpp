#include <bits/stdc++.h>

using namespace std;

pair<int, int> coords[5000];

int square(int n) { return n * n; }

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) cin >> coords[i].first;
	for (int i = 0; i < n; i++) cin >> coords[i].second;
	int max_dist = 0;
	for (int i = 1; i < n; i++) {
		for (int j = 0; j < i; j++) {
			int dist = square(coords[i].first - coords[j].first) + square(coords[i].second - coords[j].second);
			max_dist = max(max_dist, dist);
		}
	}
	cout << max_dist << '\n';
	return 0;
}