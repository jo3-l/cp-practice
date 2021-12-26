#include <bits/stdc++.h>

using namespace std;

int m[1001][1001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, q;
	cin >> n >> q;
	for (int y = 1; y <= n; y++) {
		for (int x = 1; x <= n; x++) {
			char c;
			cin >> c;
			m[y][x] = c == '*';
			m[y][x] += m[y - 1][x];
			m[y][x] += m[y][x - 1];
			m[y][x] -= m[y - 1][x - 1];
		}
	}

	while (q--) {
		int y1, x1, y2, x2;
		cin >> y1 >> x1 >> y2 >> x2;
		cout << m[y2][x2] - m[y2][x1 - 1] - m[y1 - 1][x2] + m[y1 - 1][x1 - 1] << '\n';
	}

	return 0;
}