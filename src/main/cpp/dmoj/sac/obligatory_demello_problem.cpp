#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	string s;
	cin >> s;
	int cnt = count_if(s.begin(), s.end(), [](char c) {
		switch (c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'y':
				return true;
			default:
				return false;
		}
	});
	cout << (cnt >= 2 ? "good" : "bad") << '\n';
	return 0;
}