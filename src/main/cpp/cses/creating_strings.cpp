#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	string s;
	cin >> s;
	sort(s.begin(), s.end());
	unordered_set<string> seen;
	string buf;
	do {
		if (!seen.count(s)) {
			buf += s;
			buf += '\n';
		}
		seen.insert(s);
	} while (next_permutation(s.begin(), s.end()));
	cout << seen.size() << '\n' << buf;
	return 0;
}