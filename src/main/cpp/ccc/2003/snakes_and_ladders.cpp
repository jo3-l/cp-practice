#include <bits/stdc++.h>

using namespace std;

int jmp[101];

int main() {
	jmp[54] = 19;
	jmp[90] = 48;
	jmp[99] = 77;
	jmp[9] = 34;
	jmp[40] = 64;
	jmp[67] = 86;

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int pos = 1;
	while (pos != 100) {
		int n;
		cin >> n;
		if (!n) {
			cout << "You Quit!" << '\n';
			return 0;
		}

		if (pos + n <= 100) {
			pos += n;
			if (jmp[pos]) pos = jmp[pos];
		}
		cout << "You are now on square " << pos << '\n';
	}

	cout << "You Win!" << '\n';
	return 0;
}