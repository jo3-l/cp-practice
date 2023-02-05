#include <bits/stdc++.h>

using namespace std;

struct observation {
	int time, pos;
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	vector<observation> observations(n);
	for (auto& o : observations) cin >> o.time >> o.pos;
	sort(observations.begin(), observations.end(), [](observation& a, observation& b) { return a.time < b.time; });

	long double speed = 0;
	for (int i = 0; i < n - 1; i++) {
		int dist = abs(observations[i + 1].pos - observations[i].pos);
		speed = max(speed, (long double)dist / (observations[i + 1].time - observations[i].time));
	}
	cout << fixed << speed << '\n';
}