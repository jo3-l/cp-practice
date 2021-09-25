#include <bits/stdc++.h>

using namespace std;

const int MN = 1'000'000'000;
const int X = 0x3f3f3f3f;

int original_grid[3][3];
int grid[3][3];

void fill_row(int r) {
	if (grid[r][0] != X && grid[r][1] != X) {
		grid[r][2] = grid[r][1] + grid[r][1] - grid[r][0];
	} else if (grid[r][0] != X && grid[r][2] != X) {
		grid[r][1] = (grid[r][2] + grid[r][0]) >> 1;
	} else {
		grid[r][0] = grid[r][1] - (grid[r][2] - grid[r][1]);
	}
}

void fill_col(int c) {
	if (grid[0][c] != X && grid[1][c] != X) {
		grid[2][c] = grid[1][c] + grid[1][c] - grid[0][c];
	} else if (grid[0][c] != X && grid[2][c] != X) {
		grid[1][c] = (grid[2][c] + grid[0][c]) >> 1;
	} else {
		grid[0][c] = grid[1][c] - (grid[2][c] - grid[1][c]);
	}
}

bool check() {
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (grid[i][j] > MN || grid[i][j] < -MN) return false;
		}

		if (grid[i][2] - grid[i][1] != grid[i][1] - grid[i][0] ||
		    grid[2][i] - grid[1][i] != grid[1][i] - grid[0][i])
			return false;
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			string s;
			cin >> s;
			original_grid[i][j] = grid[i][j] = s[0] == 'X' ? X : stoi(s);
		}
	}

	random_device rd;
	mt19937 rng(rd());
	uniform_int_distribution<int> uni(-MN, MN);
	while (!check()) {
		memcpy(grid, original_grid, sizeof(original_grid));

		int xs = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				xs += grid[i][j] == X;
		}

		while (xs) {
			bool did_work = false;
			for (int i = 0; i < 3; i++) {
				int row_known = 0, col_known = 0;
				for (int j = 0; j < 3; j++) {
					row_known += grid[i][j] != X;
					col_known += grid[j][i] != X;
				}

				if (row_known == 2 || col_known == 2) {
					if (row_known == 2)
						fill_row(i);
					else
						fill_col(i);

					xs--;
					did_work = true;
				}
			}

			if (!did_work) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (grid[i][j] == X) {
							grid[i][j] = uni(rng);
							xs--;
							goto after;
						}
					}
				}
			}

		after:;
		}
	}

	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (j > 0) cout << ' ';
			cout << grid[i][j];
		}
		cout << '\n';
	}
	return 0;
}