#include <bits/stdc++.h>

using namespace std;

int r, c;
int matrix[100][100];
bool seen[100][100];

const int dx[]{1, 0, -1, 0};
const int dy[]{0, 1, 0, -1};

bool go(int i, int j, int msk) {
	for (int d = 0; d < 4; d++) {
		int n_i = i + dy[d], n_j = j + dx[d];
		if (0 <= n_i && n_i < r && 0 <= n_j && n_j < c && (msk & (1 << matrix[n_i][n_j])) && !seen[n_i][n_j]) {
			if (n_i == r - 1) return true;
			seen[n_i][n_j] = true;
			if (go(n_i, n_j, msk)) return true;
		}
	}
	return false;
}

bool check(int msk) {
	for (int start_j = 0; start_j < c; start_j++) {
		if (msk & (1 << matrix[0][start_j])) {
			if (r == 1) return true;
			memset(seen, false, sizeof(seen));
			seen[0][start_j] = true;
			if (go(0, start_j, msk)) return true;
		}
	}
	return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	cin >> c >> r;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) cin >> matrix[i][j];
	}

	for (int x = 0; x <= 9; x++) {
		for (int y = 0; y <= 9; y++) {
			for (int z = 0; z <= 9; z++) {
				if (check((1 << x) | (1 << y) | (1 << z))) {
					cout << x << ' ' << y << ' ' << z << '\n';
					return 0;
				}
			}
		}
	}

	cout << -1 << ' ' << -1 << ' ' << -1 << '\n';
	return 0;
}