#include <bits/stdc++.h>

using namespace std;

bool ok[26];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	memset(ok, false, sizeof(ok));
	for (char c : {'I', 'O', 'S', 'H', 'Z', 'X', 'N'})
		ok[c - 'A'] = true;
	string s;
	cin >> s;
	cout << (all_of(s.begin(), s.end(), [&](char c) { return ok[c - 'A']; }) ? "YES" : "NO") << '\n';

	return 0;
}