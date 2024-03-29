#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	array<int, 5> loc;
	for (int i = 1; i <= 4; i++) {
		int dist;
		cin >> dist;
		loc[i] = loc[i - 1] + dist;
	}

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			if (j > 0) cout << ' ';
			cout << abs(loc[i] - loc[j]);
		}
		cout << '\n';
	}
}