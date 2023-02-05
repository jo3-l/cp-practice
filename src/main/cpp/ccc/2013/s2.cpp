#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int w, n;
	cin >> w >> n;
	vector<int> cars(n);
	for (auto& c : cars) cin >> c;

	int cur_weight = 0;
	int i;
	for (i = 0; i < n; i++) {
		cur_weight += cars[i];
		if (i >= 4) cur_weight -= cars[i - 4];
		if (cur_weight > w) break;
	}
	cout << i << '\n';
}