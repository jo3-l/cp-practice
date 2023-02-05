#include <bits/stdc++.h>

using namespace std;

constexpr int SQUARE_SIZE = 4;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	array<array<int, SQUARE_SIZE>, SQUARE_SIZE> square;
	for (auto& row : square) {
		for (auto& x : row) cin >> x;
	}

	auto is_magic = [&] {
		auto total = accumulate(square[0].begin(), square[0].end(), 0);
		if (!all_of(square.begin() + 1, square.end(), [&](auto& row) { return accumulate(row.begin(), row.end(), 0) == total; })) {
			return false;
		}

		for (int j = 0; j < SQUARE_SIZE; j++) {
			int col_sum = 0;
			for (int i = 0; i < SQUARE_SIZE; i++) col_sum += square[i][j];
			if (col_sum != total) return false;
		}
		return true;
	};
	cout << (is_magic() ? "magic" : "not magic") << '\n';
}