#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	map<int, vector<pair<int, int>>> platforms;
	for (int i = 0; i < n; i++) {
		int altitude, start, end;
		cin >> altitude >> start >> end;
		platforms[altitude].push_back({start, end});
	}

	int ans = 0;
	for (auto& [altitude, level] : platforms) {
		for (auto [start, end] : level) {
			int left_h = altitude, right_h = altitude;
			for (auto& [prev_altitude, prev_level] : platforms) {
				if (prev_altitude >= altitude) break;
				for (auto [prev_start, prev_end] : prev_level) {
					if (prev_start <= start && start < prev_end) left_h = altitude - prev_altitude;
					if (prev_start < end && end <= prev_end) right_h = altitude - prev_altitude;
				}
			}

			ans += left_h + right_h;
		}
	}

	cout << ans << '\n';
	return 0;
}