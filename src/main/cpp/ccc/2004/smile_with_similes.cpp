#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 5;
string adjectives[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++) cin >> adjectives[i];
	while (m--) {
		string s;
		cin >> s;
		for (int i = 0; i < n; i++) cout << adjectives[i] << " as " << s << '\n';
	}

	return 0;
}