#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	int t = 0, s = 0;
	while (n--) {
		cin >> ws;
		string line;
		getline(cin, line);
		t += count_if(line.begin(), line.end(), [](char c) { return c == 't' || c == 'T'; });
		s += count_if(line.begin(), line.end(), [](char c) { return c == 's' || c == 'S'; });
	}

	cout << (t > s ? "English" : "French") << '\n';

	return 0;
}