#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	char last_dir = 'l';
	while (cin >> s) {
		if (s == "99999") break;
		int sum = s[0] - '0' + s[1] - '0';
		char dir;
		if (sum == 0)
			dir = last_dir;
		else if (sum & 1)
			dir = 'l';
		else
			dir = 'r';
		last_dir = dir;

		int steps = (s[2] - '0') * 100 + (s[3] - '0') * 10 + s[4] - '0';
		cout << (dir == 'r' ? "right" : "left") << ' ' << steps << '\n';
	}

	return 0;
}