#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	string s;
	cin >> s;

	int longest = 1;
	for (auto i = s.begin(); i != s.end(); ++i) {
		for (auto j = i + 1; j <= s.end(); ++j) {
			int len = distance(i, j);
			if (equal(i, i + len / 2, make_reverse_iterator(j))) longest = max(longest, len);
		}
	}
	cout << longest << '\n';
}