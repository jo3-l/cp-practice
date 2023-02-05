#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int h = 0, v = 0;
	string flips;
	cin >> flips;
	for (char c : flips) {
		if (c == 'H')
			h ^= 1;
		else
			v ^= 1;
	}

	array<array<int, 2>, 2> board{array{1, 2}, array{3, 4}};
	if (h) reverse(board.begin(), board.end());
	if (v)
		for (auto& row : board) reverse(row.begin(), row.end());

	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2; j++) {
			if (j > 0) cout << ' ';
			cout << board[i][j];
		}
		cout << '\n';
	}
}