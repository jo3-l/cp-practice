#include <bits/stdc++.h>

using namespace std;

constexpr int INF = 0x3f3f3f3f;

constexpr int MR = 1024, MC = 1024;
int col_sums[MC];
int matrices[3][MR][MC];
int pos = 0;

void read_matrix(int dest[MR][MC], int r, int c) {
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++)
			cin >> dest[i][j];
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	int prev_r, prev_c;
	cin >> prev_r >> prev_c;
	read_matrix(matrices[pos], prev_r, prev_c);

	while (--n) {
		int r, c;
		cin >> r >> c;

		auto prev = matrices[pos], cur = matrices[(pos + 1) % 3], tp = matrices[(pos + 2) % 3];
		read_matrix(cur, r, c);
		for (int i = 0; i < prev_r; i++) {
			for (int j = 0; j < prev_c; j++) {
				for (int k = 0; k < r; k++) {
					for (int l = 0; l < c; l++) {
						tp[(i * r) + k][(j * c) + l] = prev[i][j] * cur[k][l];
					}
				}
			}
		}

		prev_r = r * prev_r;
		prev_c = c * prev_c;
		pos = (pos + 2) % 3;
	}

	int max_elem = -INF, min_elem = INF, max_row_sum = -INF, min_row_sum = INF;
	for (int i = 0; i < prev_r; i++) {
		int row_sum = 0;
		for (int j = 0; j < prev_c; j++) {
			max_elem = max(max_elem, matrices[pos][i][j]);
			min_elem = min(min_elem, matrices[pos][i][j]);
			col_sums[j] += matrices[pos][i][j];
			row_sum += matrices[pos][i][j];
		}

		max_row_sum = max(max_row_sum, row_sum);
		min_row_sum = min(min_row_sum, row_sum);
	}

	int *max_col_sum, *min_col_sum;
	tie(min_col_sum, max_col_sum) = minmax_element(begin(col_sums), begin(col_sums) + prev_c);
	cout << max_elem << '\n'
	     << min_elem << '\n'
	     << max_row_sum << '\n'
	     << min_row_sum << '\n'
	     << *max_col_sum << '\n'
	     << *min_col_sum << '\n';

	return 0;
}