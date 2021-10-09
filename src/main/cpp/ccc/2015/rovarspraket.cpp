#include <bits/stdc++.h>

using namespace std;

bool consonant[26];
char closest[26];
char nxt[26];

int main() {
	memset(consonant, true, sizeof(consonant));
	for (char c : {'a', 'e', 'i', 'o', 'u'})
		consonant[c - 'a'] = false;

	for (int i = 0; i < 26; i++) {
		if (!consonant[i]) continue;
		int next_consonant;
		for (next_consonant = i + 1; next_consonant < 26; next_consonant++) {
			if (consonant[next_consonant]) break;
		}
		nxt[i] = min(next_consonant, 25) + 'a';

		int prev_vowel;
		for (prev_vowel = i - 1; prev_vowel >= 0; prev_vowel--) {
			if (!consonant[prev_vowel]) break;
		}
		int next_vowel;
		for (next_vowel = i + 1; next_vowel < 26; next_vowel++) {
			if (!consonant[next_vowel]) break;
		}

		bool choose_prev = next_vowel >= 26 || (prev_vowel >= 0 && abs(i - prev_vowel) <= abs(i - next_vowel));
		closest[i] = (choose_prev ? prev_vowel : next_vowel) + 'a';
	}

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	cin >> s;

	for (char c : s) {
		cout << c;
		c -= 'a';
		if (consonant[c]) cout << closest[c] << nxt[c];
	}
	cout << '\n';
	return 0;
}