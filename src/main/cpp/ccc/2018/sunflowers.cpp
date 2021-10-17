#include <bits/stdc++.h>

using namespace std;

const int MN = 100;
int measurements[MN][MN];
int rotated[MN][MN];

int n;

bool valid() {
	for (int i = 0; i < n; i++) {
		if (!is_sorted(begin(measurements[i]), begin(measurements[i]) + n)) return false;
	}

	for (int j = 0; j < n; j++) {
		for (int i = 1; i < n; i++) {
			if (measurements[i][j] < measurements[i - 1][j]) return false;
		}
	}
	return true;
}

void rotate() {
	for (int i = 0; i < n / 2; i++) {
		for (int j = 0; j < n; j++) {
			rotated[j][n - i - 1] = measurements[i][j];
		}
	}
	memcpy(measurements, rotated, sizeof(measurements));
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) cin >> measurements[i][j];
	}

	while (!valid()) rotate();
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (j > 0) cout << ' ';
			cout << measurements[i][j];
		}
		cout << '\n';
	}

	return 0;
}