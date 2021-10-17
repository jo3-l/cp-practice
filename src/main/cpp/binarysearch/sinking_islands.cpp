#include <bits/stdc++.h>

using namespace std;

const int di[] = {1, -1, 0, 0};
const int dj[] = {0, 0, 1, -1};

vector<vector<int>> solve(vector<vector<int>> &board) {
	int R = (int)board.size();
	int C = (int)board[0].size();
	function<void(int, int, int)> color_land = [&](int i, int j, int c) {
		board[i][j] = c;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d], nj = j + dj[d];
			if (0 <= ni && ni < R && 0 <= nj && nj < C && board[ni][nj] == 1) color_land(ni, nj, c);
		}
	};

	for (int i = 0; i < R; i++) {
		if (i == 0 || i == R - 1) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 1) color_land(i, j, -1);
			}
		} else {
			if (board[i][0] == 1) color_land(i, 0, -1);
			if (board[i][C - 1] == 1) color_land(i, C - 1, -1);
		}
	}

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (board[i][j] == 1) color_land(i, j, 0);
		}
	}

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (board[i][j] == -1) board[i][j] = 1;
		}
	}
	return board;
}