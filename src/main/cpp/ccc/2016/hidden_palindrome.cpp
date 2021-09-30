#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	cin >> s;

	int ans = 0;
	for (int center = 0; center < s.size(); center++) {
		// odd length palindrome
		for (int l = center, r = center; l >= 0 && r < s.size() && s[l] == s[r]; l--, r++) {
			ans = max(ans, r - l + 1);
		}
		// even length palindrome
		for (int l = center, r = center + 1; l >= 0 && r < s.size() && s[l] == s[r]; l--, r++) {
			ans = max(ans, r - l + 1);
		}
	}
	cout << ans << '\n';

	return 0;
}