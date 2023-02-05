#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int x;
	cin >> x;
	vector<pair<string, string>> must(x);
	for (auto& [a, b] : must) cin >> a >> b;
	int y;
	cin >> y;
	vector<pair<string, string>> must_not(y);
	for (auto& [a, b] : must_not) cin >> a >> b;

	int g;
	cin >> g;
	unordered_map<string, int> grp;
	while (g--) {
		string a, b, c;
		cin >> a >> b >> c;
		grp[a] = grp[b] = grp[c] = g;
	}

	int cnt = 0;
	for (auto [a, b] : must) cnt += grp[a] != grp[b];
	for (auto [a, b] : must_not) cnt += grp[a] == grp[b];
	cout << cnt << '\n';
}
