#include <bits/stdc++.h>

using namespace std;

char tmpl[50][50];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int r, c, zr, zc;
	cin >> r >> c >> zr >> zc;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) cin >> tmpl[i][j];
	}

	for (int i = 0; i < r * zr; i++) {
		for (int j = 0; j < c * zc; j++) cout << tmpl[i / zr][j / zc];
		cout << '\n';
	}

	return 0;
}