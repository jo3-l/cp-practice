#include <bits/stdc++.h>

using namespace std;

string a[40], b[40];
int m, n, k;
int seq[40];

bool solve(int i) {
	if (i == k) {
		string a_s, b_s;
		for (int j = 0; j < k; j++) {
			a_s += a[seq[j]];
			b_s += b[seq[j]];
		}
		return b_s == a_s;
	}

	for (int j = 0; j < n; j++) {
		seq[i] = j;
		if (solve(i + 1)) return true;
	}
	return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> m >> n;
	for (int i = 0; i < n; i++) cin >> a[i];
	for (int i = 0; i < n; i++) cin >> b[i];
	for (k = 1; k < m; k++) {
		if (solve(0)) {
			cout << k << '\n';
			for (int i = 0; i < k; i++) cout << seq[i] + 1 << '\n';
			return 0;
		}
	}

	cout << "No solution." << '\n';
	return 0;
}