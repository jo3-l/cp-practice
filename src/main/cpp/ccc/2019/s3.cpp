#include <bits/stdc++.h>

using namespace std;

constexpr int MAX_N = 1'000'000'000;
constexpr int X = 0x3f3f3f3f; // represents unknown

struct grid {
	array<array<int, 3>, 3> entries;

	void fill_row(int r) {
		if (entries[r][0] != X && entries[r][1] != X)
			entries[r][2] = entries[r][1] + entries[r][1] - entries[r][0];
		else if (entries[r][0] != X && entries[r][2] != X)
			entries[r][1] = (entries[r][2] + entries[r][0]) / 2;
		else
			entries[r][0] = entries[r][1] - (entries[r][2] - entries[r][1]);
	}

	void fill_col(int c) {
		if (entries[0][c] != X && entries[1][c] != X)
			entries[2][c] = entries[1][c] + entries[1][c] - entries[0][c];
		else if (entries[0][c] != X && entries[2][c] != X)
			entries[1][c] = (entries[2][c] + entries[0][c]) / 2;
		else
			entries[0][c] = entries[1][c] - (entries[2][c] - entries[1][c]);
	}

	bool is_arith_square() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (entries[i][j] > MAX_N || entries[i][j] < -MAX_N) return false;
			}

			if (entries[i][2] - entries[i][1] != entries[i][1] - entries[i][0] ||
			    entries[2][i] - entries[1][i] != entries[1][i] - entries[0][i])
				return false;
		}
		return true;
	}
};

istream& operator>>(istream& is, grid& g) {
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			string item;
			is >> item;
			if (item == "X")
				g.entries[i][j] = X;
			else
				g.entries[i][j] = stoi(item);
		}
	}
	return is;
}
ostream& operator<<(ostream& os, grid& g) {
	for (int i = 0; i < 3; i++) {
		if (i > 0) cout << '\n';
		for (int j = 0; j < 3; j++) {
			if (j > 0) cout << ' ';
			os << g.entries[i][j];
		}
	}
	return os;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	grid g;
	cin >> g;
	grid orig_g = g;

	random_device rd;
	mt19937 rng(rd());
	uniform_int_distribution<int> distrib(-MAX_N, MAX_N);
	while (!g.is_arith_square()) {
		g = orig_g;

		int unknowns = 0;
		for (auto& row : g.entries) unknowns += count(row.begin(), row.end(), X);

		while (unknowns) {
			int orig_unknowns = unknowns;

			// try to fill rows/columns with one unknown only
			for (int i = 0; i < 3; i++) {
				int row_known = 0, col_known = 0;
				for (int j = 0; j < 3; j++) {
					row_known += g.entries[i][j] != X;
					col_known += g.entries[j][i] != X;
				}

				if (row_known == 2) {
					g.fill_row(i);
					unknowns--;
				} else if (col_known == 2) {
					g.fill_col(i);
					unknowns--;
				}
			}

			// if we haven't made any progress, replace one unknown with random number
			if (unknowns == orig_unknowns) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (g.entries[i][j] == X) {
							g.entries[i][j] = distrib(rng);
							unknowns--;
							goto again;
						}
					}
				}
			}

		again:;
		}
	}

	cout << g << '\n';
}
