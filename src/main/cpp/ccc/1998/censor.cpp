#include <bits/stdc++.h>

using namespace std;

void solve() {
	string s;
	getline(cin >> ws, s);
	stringstream ss(s);
	int i = 0;
	for (string word; ss >> word; i++) {
		if (i > 0) cout << ' ';
		cout << (word.size() == 4 ? "****" : word);
	}
	cout << '\n';
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	while (n--) solve();

	return 0;
}