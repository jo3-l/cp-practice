#include <bits/stdc++.h>

using namespace std;

constexpr int COMMUTE_DIST = 4 * 60;
constexpr int NORMAL_SPEED_PER_M = 2;
constexpr int RUSH_HOUR_SPEED_PER_M = 1;

constexpr int H = 60;

int to_time(string& s) {
	int h = (s[0] - '0') * 10 + s[1] - '0';
	int m = (s[3] - '0') * 10 + s[4] - '0';
	return h * 60 + m;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	cin >> s;
	int time = to_time(s);
	int remaining_dist = COMMUTE_DIST;
	while (remaining_dist > 0) {
		if ((7 * H <= time && time < 10 * H) || (15 * H <= time && time < 19 * H))
			remaining_dist -= RUSH_HOUR_SPEED_PER_M;
		else
			remaining_dist -= NORMAL_SPEED_PER_M;

		time = (time + 1) % (24 * H);
	}

	int h = time / 60, m = time % 60;
	cout << setw(2) << setfill('0') << h << ':' << setw(2) << setfill('0') << m << '\n';

	return 0;
}