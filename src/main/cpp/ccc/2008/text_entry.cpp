#include <bits/stdc++.h>

using namespace std;

pair<int, int> get_pos(char c) {
	if (c == ' ') return {4, 2};
	if (c == '-') return {4, 3};
	if (c == '.') return {4, 4};
	if (c == '$') return {4, 5};
	return {(c - 'A') / 6, (c - 'A') % 6};
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	getline(cin, s);
	s.push_back('$');
	pair<int, int> cur{0, 0};
	int ans = 0;
	for (char c : s) {
		pair<int, int> target = get_pos(c);
		ans += abs(cur.first - target.first) + abs(cur.second - target.second);
		cur = move(target);
	}
	cout << ans << '\n';
	return 0;
}