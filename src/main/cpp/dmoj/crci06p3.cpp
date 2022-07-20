#include <bits/stdc++.h>

using namespace std;

constexpr int INF = 0x3f3f3f3f;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, h;
	cin >> n >> h;
	vector<int> even_heights(n >> 1), odd_heights(n >> 1);
	for (int i = 0; i < n; i++) {
		if (i & 1)
			cin >> odd_heights[i >> 1];
		else
			cin >> even_heights[i >> 1];
	}
	sort(odd_heights.begin(), odd_heights.end());
	sort(even_heights.begin(), even_heights.end());

	int min_obstacles = INF, cnt = 0;
	for (int i = 1; i <= h; i++) {
		int even_cnt = even_heights.end() - lower_bound(even_heights.begin(), even_heights.end(), i);
		int odd_cnt = odd_heights.end() - lower_bound(odd_heights.begin(), odd_heights.end(), h - i + 1);
		int total = even_cnt + odd_cnt;
		if (total < min_obstacles)
			min_obstacles = total, cnt = 1;
		else if (total == min_obstacles)
			cnt++;
	}
	cout << min_obstacles << ' ' << cnt << '\n';
}