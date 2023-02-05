#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;

	vector<int> swifts(n), sephamores(n);
	for (auto& s : swifts) cin >> s;
	for (auto& s : sephamores) cin >> s;

	int swift_runs = 0, sephamore_runs = 0;
	int k = 0;
	for (int i = 0; i < n; i++) {
		swift_runs += swifts[i];
		sephamore_runs += sephamores[i];
		if (swift_runs == sephamore_runs) k = max(k, i + 1);
	}
	cout << k << '\n';
}