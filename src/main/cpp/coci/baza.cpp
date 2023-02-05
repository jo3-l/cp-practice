#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, m;
	cin >> n >> m;
	vector<vector<int>> data(n, vector<int>(m));
	for (auto& entry : data) {
		for (auto& x : entry) cin >> x;
	}

	int q;
	cin >> q;
	vector<int> params(m);
	while (q--) {
		for (auto& x : params) cin >> x;
		int ans = 0;
		for (auto& entry : data) {
			int i;
			for (i = 0; i < m; i++) {
				if (params[i] != -1 && entry[i] != params[i]) break;
			}
			ans += i == m;
		}
		cout << ans << '\n';
	}

	return 0;
}