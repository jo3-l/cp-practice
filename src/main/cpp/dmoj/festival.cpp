#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	// transposed
	vector<vector<char>> grid(n, vector<char>(n));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) cin >> grid[j][i];
	}

	vector<int> cnt(n);
	for (int i = 0; i < n; i++) cnt[i] = count(grid[i].begin(), grid[i].end(), 'S');
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << (i >= n - cnt[j] ? 'S' : '.');
		}
		cout << '\n';
	}
}