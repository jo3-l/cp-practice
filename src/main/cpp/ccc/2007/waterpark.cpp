#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 10'000;
vector<int> slides[MN];
int dp[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;

	int x, y;
	for (cin >> x >> y; x; cin >> x >> y) slides[x].push_back(y);

	dp[n] = 1;
	for (int i = n - 1; i >= 1; i--) {
		for (int k : slides[i]) dp[i] += dp[k];
	}
	cout << dp[1] << '\n';

	return 0;
}