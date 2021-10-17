#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string key, msg;
	getline(cin, key);
	getline(cin, msg);
	int n = 0;
	for (char c : msg) {
		if ('A' <= c && c <= 'Z') {
			int enc = (c - 'A') + key[n++ % key.size()] - 'A';
			if (enc >= 26) enc -= 26;
			cout << (char)(enc + 'A');
		}
	}

	cout << '\n';
	return 0;
}