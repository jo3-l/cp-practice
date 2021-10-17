#include <bits/stdc++.h>

using namespace std;

int cnt[2];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int votes;
	cin >> votes;
	while (votes--) {
		char c;
		cin >> c;
		cnt[c - 'A']++;
	}
	if (cnt[0] > cnt[1]) cout << 'A' << '\n';
	else if (cnt[0] == cnt[1]) cout << "Tie" << '\n';
	else cout << 'B' << '\n';

	return 0;
}