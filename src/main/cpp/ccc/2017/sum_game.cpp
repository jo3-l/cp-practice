#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 100'001;
int swift_runs[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	for (int d = 1; d <= n; d++) {
		cin >> swift_runs[d];
		if (d > 0) swift_runs[d] += swift_runs[d - 1];
	}

	int ans = 0;
	int sephamore_runs = 0;
	for (int d = 1; d <= n; d++) {
		int k;
		cin >> k;
		sephamore_runs += k;
		if (sephamore_runs == swift_runs[d]) ans = max(ans, d);
	}
	cout << ans << '\n';

	return 0;
}