#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	string insts;
	cin >> insts;

	int i = 0;
	string strs;
	while (i < insts.size()) {
		char c = insts[i++];
		if (c == '-' || c == '+') {
			cout << strs << ' ' << (c == '-' ? "loosen" : "tighten") << ' ';
			strs.clear();
			while (i < insts.size() && isdigit(insts[i])) cout << insts[i++];
			cout << '\n';
		} else {
			strs.push_back(c);
		}
	}
	return 0;
}