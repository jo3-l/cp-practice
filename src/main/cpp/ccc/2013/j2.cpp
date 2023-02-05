#include <bits/stdc++.h>

using namespace std;

string symmetric_chars = "IOSHZXN";

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	cin >> s;
	cout << (all_of(s.begin(), s.end(), [&](char c) { return symmetric_chars.find(c) != string::npos; }) ? "YES" : "NO") << '\n';
}
