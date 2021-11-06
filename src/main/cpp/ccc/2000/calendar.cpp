#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int s, n;
	cin >> s >> n;
	cout << "Sun Mon Tue Wed Thr Fri Sat" << '\n';
	cout << setw((s - 1) * 4 + 3) << 1;
	int d = 2;
	for (int i = 0; i < 7 - s; i++) cout << setw(4) << d++;
	cout << '\n';
	while (d <= n) {
		for (int stop = min(n, d + 6); d <= stop; d++) {
			cout << setw(3) << d;
			if (d < stop) cout << ' ';
		}
		cout << '\n';
	}

	return 0;
}
