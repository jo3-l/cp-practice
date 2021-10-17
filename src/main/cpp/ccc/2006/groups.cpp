#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 105;
int mul[MN][MN];

int n;

bool is_associative() {
	for (int x = 1; x <= n; x++) {
		for (int y = 1; y <= n; y++) {
			for (int z = 1; z <= n; z++) {
				if (mul[x][y] <= 0 || mul[x][y] > n || mul[y][z] <= 0 || mul[y][z] > n) return false;
				if (mul[mul[x][y]][z] != mul[x][mul[y][z]]) return false;
			}
		}
	}
	return true;
}

int get_identity_element() {
	for (int i = 1; i <= n; i++) {
		int x;
		for (x = 1; x <= n; x++) {
			if (mul[x][i] != x || mul[i][x] != x) break;
		}
		if (x > n) return i;
	}
	return -1;
}

bool has_inverse(int i) {
	for (int x = 1; x <= n; x++) {
		int k;
		for (k = 1; k <= n; k++) {
			if (mul[x][k] == i && mul[k][x] == i) break;
		}
		if (k > n) return false;
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (cin >> n; n; cin >> n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) cin >> mul[i][j];
		}
		if (!is_associative()) {
			cout << "no" << '\n';
		} else {
			int i = get_identity_element();
			if (i == -1 || !has_inverse(i)) cout << "no" << '\n';
			else cout << "yes" << '\n';
		}
	}

	return 0;
}