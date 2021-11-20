#include <bits/stdc++.h>

using namespace std;

char symbol[10][10];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

#ifndef LOCAL
	freopen("cowsignal.in", "r", stdin);
	freopen("cowsignal.out", "w", stdout);
#endif

	int m, n, k;
	cin >> m >> n >> k;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) cin >> symbol[i][j];
	}
	for (int i = 0; i < k * m; i++) {
		for (int j = 0; j < k * n; j++) cout << symbol[i / k][j / k];
		cout << '\n';
	}

	return 0;
}