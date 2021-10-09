#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 10'000;
pair<string, int> p[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int r, s, d;
		cin >> p[i].first >> r >> s >> d;
		p[i].second = 2 * r + 3 * s + d;
	}
	sort(begin(p), begin(p) + n, [](const pair<string, int> a, const pair<string, int> b) {
		return a.second > b.second || (a.second == b.second && a.first < b.first);
	});
	if (n > 0) cout << p[0].first << '\n';
	if (n > 1) cout << p[1].first << '\n';
	return 0;
}