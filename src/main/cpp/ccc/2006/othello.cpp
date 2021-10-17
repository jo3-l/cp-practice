#include <bits/stdc++.h>

using namespace std;

constexpr int UNUSED = -1, WHITE = 0, BLACK = 1;
int board[8][8];
int cnt[2];

const int di[]{0, -1, -1, -1, 0, 1, 1, 1};
const int dj[]{-1, -1, 0, 1, 1, 1, 0, -1};

int main() {
	memset(board, UNUSED, sizeof(board));
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	char conf;
	cin >> conf;
	if (conf == 'a') {
		board[3][3] = board[4][4] = WHITE;
		board[4][3] = board[3][4] = BLACK;
		cnt[WHITE] = cnt[BLACK] = 2;
	} else if (conf == 'b') {
		for (int i = 0; i < 8; i++) {
			board[i][i] = BLACK;
			cnt[BLACK]++;
			board[i][7 - i] = WHITE;
			cnt[WHITE]++;
		}
	} else {
		for (int i = 0; i < 8; i++) {
			for (int j = 2; j < 6; j++) {
				board[i][j] = j < 4;
				cnt[j < 4]++;
			}
		}
	}

	int n;
	cin >> n;
	int player = BLACK;
	for (; n--; player ^= 1) {
		int i, j;
		cin >> i >> j;
		i--, j--;
		int other = player ^ 1;

		board[i][j] = player;
		cnt[player]++;
		for (int d = 0; d < 8; d++) {
			int ni = i + di[d], nj = j + dj[d];
			auto ok = [&]() { return 0 <= ni && ni < 8 && 0 <= nj && nj < 8; };
			while (ok() && board[ni][nj] == other) {
				ni += di[d];
				nj += dj[d];
			}

			if (ok() && board[ni][nj] == player) {
				for (ni = i + di[d], nj = j + dj[d]; ok() && board[ni][nj] == other; ni += di[d], nj += dj[d]) {
					board[ni][nj] = player;
					cnt[other]--;
					cnt[player]++;
				}
			}
		}
	}

	cout << cnt[BLACK] << ' ' << cnt[WHITE] << '\n';
	return 0;
}