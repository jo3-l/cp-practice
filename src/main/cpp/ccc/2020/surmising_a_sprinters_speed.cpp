#include <bits/stdc++.h>

using namespace std;

const int MN = 1e5;
pair<int, int> observations[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int time, pos;
		cin >> time >> pos;
		observations[i] = {time, pos};
	}
	sort(observations, observations + n);

	double speed = DBL_MIN;
	for (int i = 0; i < n - 1; i++) {
		int dist = abs(observations[i + 1].second - observations[i].second);
		speed = max(speed, dist / (double)(observations[i + 1].first - observations[i].first));
	}
	cout << fixed << speed << endl;

	return 0;
}