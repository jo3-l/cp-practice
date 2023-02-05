#include <bits/stdc++.h>

using namespace std;

bool is_wildcard_anagram(string& a, string& b) {
	array<int, 26> ctr_a{}, ctr_b{};
	for (char c : a) ctr_a[c - 'a']++;

	int wildcards = 0;
	for (char c : b) {
		if (c == '*')
			wildcards++;
		else
			ctr_b[c - 'a']++;
	}

	for (int c = 0; c < 26; c++) {
		if (ctr_b[c] > ctr_a[c]) return false;
		wildcards -= ctr_a[c] - ctr_b[c]; // compensate for missing characters
	}
	return wildcards >= 0;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	string a, b;
	cin >> a >> b;
	cout << (is_wildcard_anagram(a, b) ? 'A' : 'N') << '\n';
}