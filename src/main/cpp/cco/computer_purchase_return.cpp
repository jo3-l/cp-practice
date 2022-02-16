#include <bits/stdc++.h>

using namespace std;

struct Component {
	int cost, value;
};
vector<Component> components[6];

int dp[6][3001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int t, n;
	cin >> t >> n;
	while (n--) {
		int cost, value, typ;
		cin >> cost >> value >> typ;
		components[typ].push_back({cost, value});
	}
	int b;
	cin >> b;
	for (int i = 1; i <= t; i++) {
		for (int cur_b = 1; cur_b <= b; cur_b++) {
			for (auto [cost, value] : components[i]) {
				if (cur_b >= cost) {
					dp[i][cur_b] = max(dp[i][cur_b], dp[i - 1][cur_b - cost] + value);
				}
			}
		}
	}
	cout << *max_element(dp[t], dp[t] + b + 1) << '\n';
	return 0;
}
