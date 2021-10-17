#include <bits/stdc++.h>

using ll = long long;
using namespace std;

constexpr int MN = 30;
ll dp[MN];

vector<int> motels{0, 990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int a, b, n;
	cin >> a >> b >> n;
	while (n--) {
		int k;
		cin >> k;
		motels.push_back(k);
	}
	sort(motels.begin(), motels.end());

	dp[0] = 1;
	for (int i = 1; i < motels.size(); i++) {
		for (int j = i - 1; j >= 0; j--) {
			int dist = motels[i] - motels[j];
			if (dist > b) break;
			if (dist >= a) dp[i] += dp[j];
		}
	}

	cout << dp[motels.size() - 1] << '\n';
	return 0;
}