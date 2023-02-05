#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int t, n;
	cin >> t >> n;
	vector<int> dmojstan_speeds(n), pegland_speeds(n);
	for (auto& d : dmojstan_speeds) cin >> d;
	for (auto& p : pegland_speeds) cin >> p;

	sort(dmojstan_speeds.begin(), dmojstan_speeds.end());
	sort(pegland_speeds.begin(), pegland_speeds.end());

	int total_speed = 0;
	if (t == 1) {
		for (int i = 0; i < n; i++) total_speed += max(dmojstan_speeds[i], pegland_speeds[i]);
	} else {
		for (int d = 0, p = n - 1; d < n; d++, p--) total_speed += max(dmojstan_speeds[d], pegland_speeds[p]);
	}
	cout << total_speed << '\n';
}