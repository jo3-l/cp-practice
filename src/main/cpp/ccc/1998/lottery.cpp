#include <bits/stdc++.h>

using namespace std;

void solve() {
	vector<string> operands;
	vector<char> ops;

	string s;
	getline(cin >> ws, s);
	stringstream ss(s);
	for (string operand; ss >> operand;) {
		operands.push_back(operand);
		char op;
		if (ss >> op) ops.push_back(op);
	}
	auto simplify = [&](auto it) {
		int i = it - ops.begin();
		operands[i] = "("s + operands[i] + ' ' + *it + ' ' + operands[i + 1] + ')';
		operands.erase(operands.begin() + i + 1);
		ops.erase(it);
	};
	while (operands.size() > 2) {
		auto it = find(ops.begin(), ops.end(), 'X');
		if (it != ops.end()) simplify(it);
		else simplify(ops.begin());
	}
	cout << operands[0] << ' ' << ops[0] << ' ' << operands[1] << '\n';
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int t;
	cin >> t;
	while (t--) solve();

	return 0;
}