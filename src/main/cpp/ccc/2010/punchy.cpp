#include <bits/stdc++.h>

using namespace std;

int reg[2];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int op;
	for (cin >> op; op != 7; cin >> op) {
		char x;
		cin >> x;
		if (op == 1) {
			cin >> reg[x - 'A'];
		} else if (op == 2) {
			cout << reg[x - 'A'] << '\n';
		} else {
			char y;
			cin >> y;
			int &lhs = reg[x - 'A'], rhs = reg[y - 'A'];
			if (op == 3)
				lhs += rhs;
			else if (op == 4)
				lhs *= rhs;
			else if (op == 5)
				lhs -= rhs;
			else if (op == 6)
				lhs /= rhs;
		}
	}

	return 0;
}