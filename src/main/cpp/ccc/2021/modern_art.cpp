#include <bits/stdc++.h>

using namespace std;

using ll = long long;

constexpr int MM = 5'000'000, MN = 5'000'000;
int row_color_cnt[MM];
int col_color_cnt[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int m;
	cin >> m;
	int n;
	cin >> n;

	int k;
	cin >> k;
	while (k--) {
		char c;
		cin >> c;
		int v;
		cin >> v;
		v--; // 1-based to 0-based
		if (c == 'R') row_color_cnt[v]++;
		else col_color_cnt[v]++;
	};

	int gold = 0;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			int total = row_color_cnt[i] + col_color_cnt[j];
			gold += total & 1;
		}
	}
	cout << gold << '\n';

	return 0;
}