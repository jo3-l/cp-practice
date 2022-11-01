#include <bits/stdc++.h>

using namespace std;

bool is_vowel(char c) {
	switch (c) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			return true;
		default:
			return false;
	}
}

bool is_pronounceable(string& s) {
	bool prev = is_vowel(s[0]);
	for (int i = 1; i < s.size(); i++) {
		if (prev == is_vowel(s[i])) return false;
		prev ^= 1;
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	string s;
	cin >> s;
	cout << (is_pronounceable(s) ? "YES" : "NO") << '\n';
}