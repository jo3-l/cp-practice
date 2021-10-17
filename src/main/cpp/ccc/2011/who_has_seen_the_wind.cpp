#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int h, m;
	cin >> h >> m;
	int t;
	for (t = 1; t <= m; t++) {
		int a = -6 * t * t * t * t + h * t * t * t + 2 * t * t + t;
		if (a <= 0) break;
	}

	if (t > m) cout << "The balloon does not touch ground in the given time." << '\n';
	else cout << "The balloon first touches ground at hour:" << '\n' << t << '\n';
	return 0;
}