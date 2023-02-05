#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	string t, s;
	cin >> t >> s;
	for (int i = 0; i < s.size(); i++) {
		char c = s[0];
		s.erase(0, 1);
		s.push_back(c);
		if (t.find(s) != string::npos) {
			cout << "yes\n";
			return 0;
		}
	}
	cout << "no\n";
}