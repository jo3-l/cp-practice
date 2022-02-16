#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	string s;
	cin >> s;
	if (s.find("demello") != string::npos) cout << "liar\n";
	else cout << "what are we going to do?\n";

	return 0;
}