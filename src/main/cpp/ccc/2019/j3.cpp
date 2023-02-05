#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	while (n--) {
		string s;
		cin >> s;
		auto block_start = s.begin();
		while (block_start != s.end()) {
			auto block_end = find_if_not(block_start, s.end(), [&](char c) { return c == *block_start; });
			cout << distance(block_start, block_end) << ' ' << *block_start;
			if (block_end != s.end()) cout << ' ';

			block_start = block_end;
		}
		cout << '\n';
	}

	return 0;
}