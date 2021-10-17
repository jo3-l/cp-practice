#include <bits/stdc++.h>

using namespace std;

const char mp[] = "22233344455566677778889999";
int buf[10];
int pos;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int t;
	cin >> t;
	for (; t--; pos = 0) {
		string s;
		cin >> s;
		for (int i = 0; i < s.size() && pos < 10; i++) {
			if ('A' <= s[i] && s[i] <= 'Z') s[i] = mp[s[i] - 'A'];
			if ('0' <= s[i] && s[i] <= '9') buf[pos++] = s[i] - '0';
		}
		for (int i = 0; i < 3; i++) cout << buf[i];
		cout << '-';
		for (int i = 3; i < 6; i++) cout << buf[i];
		cout << '-';
		for (int i = 6; i < 10; i++) cout << buf[i];
		cout << '\n';
	}

	return 0;
}