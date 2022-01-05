#include <bits/stdc++.h>

using namespace std;

const int dx[]{0, 1, 0, -1};
const int dy[]{1, 0, -1, 0};

bool seen[1500][1500];
int elev[1500][1500];
int n, h;

bool go(int i, int j) {
	for (int d = 0; d < 4; d++) {
		int n_i = i + dy[d], n_j = j + dx[d];
		if (0 <= n_i && n_i < n && 0 <= n_j && n_j < n && abs(elev[n_i][n_j] - elev[i][j]) <= h) {
			if (n_i == n - 1 && n_j == n - 1) return true;
			if (!seen[n_i][n_j]) {
				seen[n_i][n_j] = true;
				if (go(n_i, n_j)) return true;
			}
		}
	}
	return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	cin >> n >> h;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) cin >> elev[i][j];
	}

	seen[0][0] = true;
	cout << (n == 1 || go(0, 0) ? "yes" : "no") << '\n';

	return 0;
}