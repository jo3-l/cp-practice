#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	getline(cin, s);
	int happy = 0, sad = 0;
	int state = 0; // 0 = ??, 1 = seen ':', 2 = seen '-'
	for (char c : s) {
		switch (state) {
		case 0:
			if (c == ':')
				state++;
			else
				state = 0;
			break;
		case 1:
			if (c == '-')
				state++;
			else
				state = 0;
			break;
		case 2:
			if (c == ')')
				happy++;
			else if (c == '(')
				sad++;
			state = 0;
			break;
		}
	}

	if (happy == 0 && sad == 0)
		cout << "none" << '\n';
	else if (happy == sad)
		cout << "unsure" << '\n';
	else if (happy > sad)
		cout << "happy" << '\n';
	else
		cout << "sad" << '\n';

	return 0;
}