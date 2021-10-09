#include <bits/stdc++.h>

using namespace std;

int input_ctr[26], pattern_ctr[26];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string input, pattern;
	cin >> input >> pattern;
	int wildcards = 0;
	for (int i = 0; i < input.size(); i++) {
		input_ctr[input[i] - 'a']++;
		if (pattern[i] == '*')
			wildcards++;
		else
			pattern_ctr[pattern[i] - 'a']++;
	}
	for (int c = 0; c < 26; c++) {
		if (input_ctr[c] != pattern_ctr[c]) {
			int delta = input_ctr[c] - pattern_ctr[c];
			if (delta <= 0 || wildcards < delta) {
				cout << 'N' << '\n';
				return 0;
			}
			wildcards -= delta;
		}
	}
	cout << 'A' << '\n';

	return 0;
}