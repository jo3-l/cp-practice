#include <bits/stdc++.h>

using namespace std;

int square[4][4];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int last_row_sum = 0;
	for (int i = 0; i < 4; i++) {
		int row_sum = 0;
		for (int j = 0; j < 4; j++) {
			cin >> square[i][j];
			row_sum += square[i][j];
		}
		if (i > 0 && row_sum != last_row_sum) {
			cout << "not magic" << '\n';
			return 0;
		}
		last_row_sum = row_sum;
	}

	int last_col_sum = 0;
	for (int j = 0; j < 4; j++) {
		int col_sum = 0;
		for (int i = 0; i < 4; i++) {
			col_sum += square[i][j];
		}
		if (j > 0 && col_sum != last_col_sum) {
			cout << "not magic" << '\n';
			return 0;
		}
		last_col_sum = col_sum;
	}

	cout << (last_row_sum == last_col_sum ? "magic" : "not magic") << '\n';
	return 0;
}