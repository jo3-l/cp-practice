#include <bits/stdc++.h>

using namespace std;

char board[8][8];
int state[8]; // state[i] denotes placement of ith queen -- row i, column state[i]

int rec(int i) {
	if (i == 8) return 1;
	int bad = 0;
	for (int j = 0; j < i; j++) bad |= 1 << state[j];
	int ans = 0;
	for (int j = 0; j < 8; j++) {
		if (board[i][j] == '*' || bad & (1 << j)) continue;
		int k;
		for (k = 0; k < i; k++) {
			if (abs(i - k) == abs(j - state[k])) break;
		}
		if (k >= i) {
			state[i] = j;
			ans += rec(i + 1);
		}
	}
	return ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) cin >> board[i][j];
	}
	cout << rec(0) << '\n';

	return 0;
}