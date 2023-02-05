#include <bits/stdc++.h>

using namespace std;

string s;

// Word ::= ('A' | 'B' Word 'S') [ 'N' Word ]
bool is_monkey_lang_word(int i, int j) {
	if (i > j) return false;
	auto check_optional_n = [&](int k) { return k > j || (s[k] == 'N' && is_monkey_lang_word(k + 1, j)); };
	if (s[i] == 'A') return check_optional_n(i + 1);
	if (s[i] != 'B') return false;
	for (size_t p = s.find('S', i + 1); p != string::npos; p = s.find('S', p + 1))
		if (is_monkey_lang_word(i + 1, p - 1) && check_optional_n(p + 1)) return true;
	return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (cin >> s; s != "X"; cin >> s) cout << (is_monkey_lang_word(0, (int)s.size() - 1) ? "YES" : "NO") << '\n';

	return 0;
}