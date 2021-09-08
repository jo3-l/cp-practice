#include <bits/stdc++.h>

using namespace std;

int di[4] = {1, -1, 0, 0};
int dj[4] = {0, 0, 1, -1};

vector<vector<int>> solve(vector<vector<int>> &board) {
	int R = (int)board.size();
	int C = (int)board[0].size();

	function<void(int, int, int)> color;
	color = [&](int i, int j, int c) {
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d], nj = j + dj[d];
			if (0 <= ni && ni < R && 0 <= nj && nj < C &&
			    board[ni][nj] == 1) {
				board[ni][nj] = c;
				color(ni, nj, c);
			}
		}
	};

	for (int i = 0; i < R; i++) {
		if (i == 0 || i == R - 1) {
			for (int j = 0; j < C; j++)
				if (board[i][j] == 1) {
					board[i][j] = -1;
					color(i, j, -1);
				}
		} else {
			if (board[i][0] == 1) {
				board[i][0] = -1;
				color(i, 0, -1);
			}
			if (board[i][C - 1] == 1) {
				board[i][C - 1] = -1;
				color(i, C - 1, -1);
			}
		}
	}

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (board[i][j] == 1) {
				board[i][j] = 0;
				color(i, j, 0);
			}
		}
	}

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (board[i][j] == -1) board[i][j] = 1;
		}
	}
	return board;
}
