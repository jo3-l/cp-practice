#include <bits/stdc++.h>

using namespace std;

unordered_map<int, vector<string>> shared_with;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, m;
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int u, v;
		string title;
		getline(cin >> u >> v >> ws, title);
		shared_with[v].push_back(title);
	}
	int y;
	cin >> y;
	for (string &title : shared_with[y]) cout << title << '\n';
	return 0;
}