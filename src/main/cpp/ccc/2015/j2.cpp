#include <bits/stdc++.h>

using namespace std;

int count_occurrences(string const& haystack, string const& needle) {
	int n = 0;
	for (size_t pos = haystack.find(needle); pos != string::npos; pos = haystack.find(needle, pos + 1)) n++;
	return n;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	string s;
	getline(cin, s);
	
	int happy = count_occurrences(s, ":-)"), sad = count_occurrences(s, ":-(");
	if (happy == 0 && sad == 0) cout << "none\n";
	else if (happy == sad) cout << "unsure\n";
	else if (happy > sad) cout << "happy\n";
	else cout << "sad\n";
}
