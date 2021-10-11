#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string line;
	for (getline(cin, line); line != "0"; getline(cin, line)) {
		stack<string> exprs;
		for (int i = line.size() - 1; i >= 0; i--) {
			char c = line[i];
			if ('0' <= c && c <= '9') {
				exprs.push(string{c});
			} else if (c != ' ') {
				string a = exprs.top();
				exprs.pop();
				string b = exprs.top();
				exprs.pop();
				exprs.push(a + " " + b + " " + c);
			}
		}
		cout << exprs.top() << '\n';
	}

	return 0;
}