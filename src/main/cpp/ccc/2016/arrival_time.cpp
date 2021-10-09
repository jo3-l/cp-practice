#include <bits/stdc++.h>

using namespace std;

constexpr int DAY = 24 * 60;
constexpr int COMMUTE_DIST = 4 * 60;
constexpr int _7H = 7 * 60;
constexpr int _10H = 10 * 60;
constexpr int _15H = 15 * 60;
constexpr int _19H = 19 * 60;

int to_time(string &s) {
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
	for (int i = 0; i < COMMUTE_DIST; time = (time + 1) % DAY) {
		if ((_7H <= time && time < _10H) || (_15H <= time && time < _19H))
			i++;
		else
			i += 2;
	}

	int h = time / 60, m = time % 60;
	cout << setw(2) << setfill('0') << h << ':' << setw(2) << setfill('0') << m << '\n';

	return 0;
}