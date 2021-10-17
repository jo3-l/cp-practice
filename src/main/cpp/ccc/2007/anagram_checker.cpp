#include <bits/stdc++.h>

using namespace std;

int a_cnt[26], b_cnt[26];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string a, b;
	getline(cin, a);
	getline(cin, b);
	for (char c : a)
		if (c != ' ') a_cnt[c - 'A']++;
	for (char c : b)
		if (c != ' ') b_cnt[c - 'A']++;

	cout << (memcmp(a_cnt, b_cnt, sizeof(a_cnt)) ? "Is not an anagram." : "Is an anagram.") << '\n';
	return 0;
}