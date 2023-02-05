#include <bits/stdc++.h>

using namespace std;

struct measurements {
	int n;
	vector<vector<int>> entries;

	measurements(int n_) : n(n_), entries(n_, vector<int>(n_)) {}

	bool is_valid() {
		for (auto& row : entries) {
			if (!is_sorted(row.begin(), row.end())) return false;
		}
		for (int j = 0; j < n; j++) {
			for (int i = 1; i < n; i++) {
				if (entries[i][j] < entries[i - 1][j]) return false;
			}
		}
		return true;
	}

	void rot90() {
		vector<vector<int>> rotated(n, vector<int>(n));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rotated[n - j - 1][i] = entries[i][j];
			}
		}
		entries = rotated;
	}
};

istream& operator>>(istream& is, measurements& ms) {
	for (auto& row : ms.entries) {
		for (auto& x : row) cin >> x;
	}
	return is;
}
ostream& operator<<(ostream& os, measurements& ms) {
	for (int i = 0; i < ms.n; i++) {
		if (i > 0) cout << '\n';
		for (int j = 0; j < ms.n; j++) {
			if (j > 0) cout << ' ';
			cout << ms.entries[i][j];
		}
	}
	return os;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	measurements ms(n);
	cin >> ms;

	while (!ms.is_valid()) ms.rot90();
	cout << ms << '\n';
}