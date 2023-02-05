#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int m, n, k;
	cin >> m >> n >> k;
	vector<bool> row_colored(m + 1), col_colored(n + 1);
	while (k--) {
		char t;
		int x;
		cin >> t >> x;
		if (t == 'R')
			row_colored[x].flip();
		else
			col_colored[x].flip();
	}

	int colored_rows = count(row_colored.begin(), row_colored.end(), true);
	int colored_cols = count(col_colored.begin(), col_colored.end(), true);
	cout << colored_rows * n + colored_cols * m - 2 * colored_rows * colored_cols << '\n';
}
