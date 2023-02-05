#include <bits/stdc++.h>

using namespace std;

string vowels = "aeiou";
string consonants = "bcdfghjklmnpqrstvwxyz";

char closest_vowel(char c) {
	char closest = vowels[0];
	int closest_dist = abs(int(c) - closest);
	for (int i = 1; i < vowels.size(); i++) {
		int dist = abs(int(vowels[i] - c));
		if (dist < closest_dist) {
			closest = vowels[i];
			closest_dist = dist;
		}
	}
	return closest;
}

char next_consonant(char c) {
	int i = consonants.find(c);
	return consonants[min(i + 1, int(consonants.size()) - 1)];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	string s;
	cin >> s;
	for (char c : s) {
		if (vowels.find(c) != string::npos)
			cout << c;
		else
			cout << c << closest_vowel(c) << next_consonant(c);
	}
	cout << '\n';
}
