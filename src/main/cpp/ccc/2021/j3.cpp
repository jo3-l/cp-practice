#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	string inst;
	char last_dir = 'l';
	while (cin >> inst) {
		if (inst == "99999") break;
		int sum = inst[0] - '0' + inst[1] - '0';
		char dir;
		if (sum == 0) dir = last_dir;
		else if (sum & 1) dir = 'l';
		else dir = 'r';
		last_dir = dir;

		int steps = (inst[2] - '0') * 100 + (inst[3] - '0') * 10 + inst[4] - '0';
		cout << (dir == 'r' ? "right" : "left") << ' ' << steps << '\n';
	}
}
