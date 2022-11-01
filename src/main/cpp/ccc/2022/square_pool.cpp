#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int n, t;
	cin >> n >> t;
	vector<pair<int, int>> trees{{0, 0}, {0, n + 1}, {n + 1, 0}, {n + 1, n + 1}};
	while (t--) {
		int x, y;
		cin >> x >> y;
		trees.push_back({x, y});
	}
    int ans = 0;
	for (int i = 0; i < trees.size(); i++) {
		for (int j = 0; j < trees.size(); j++) {
			auto [x1, y1] = trees[i]; // assume left border
			auto [x2, y2] = trees[j]; // assume top border
			if (x1 == x2 || y1 == y2) continue;
            // look for right border
            for (int k = 0; k < trees.size(); k++) {
                auto [x3, y3] = trees[k]; // assume right border
                if (x3 == x1 || x3 == x2 || y3 == y1 || y3 == y2) continue;
                ans = max(ans, y3 - y1);
            }
		}
	}
	return 0;
}