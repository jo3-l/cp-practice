#include <bits/stdc++.h>

using namespace std;

bool is_vowel(char c) { return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y'; }

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	for (getline(cin, s); s != "quit!"; getline(cin, s)) {
		if (s.size() >= 4 && !is_vowel(s[s.size() - 3]) && s.compare(s.size() - 2, 2, "or") == 0) {
			s.erase(s.size() - 2);
			s += "our";
		}
		cout << s << '\n';
	}

	return 0;
}