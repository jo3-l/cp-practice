#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int comb[]{1, 2, 3};
	string s;
	cin >> s;
	for (char c : s) swap(comb[c - 'A'], comb[(c - 'A' + 1) % 3]);
	cout << find(begin(comb), end(comb), 1) - begin(comb) + 1 << '\n';

	return 0;
}