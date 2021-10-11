#include <bits/stdc++.h>

using namespace std;

char playlist[]{'A', 'B', 'C', 'D', 'E'};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int op, n;
	for (cin >> op >> n; op != 4; cin >> op >> n) {
		if (op == 1) {
			while (n--) {
				char first = playlist[0];
				memmove(playlist, playlist + 1, sizeof(char) * 4);
				playlist[4] = first;
			}
		} else if (op == 2) {
			while (n--) {
				char last = playlist[4];
				memmove(playlist + 1, playlist, sizeof(char) * 4);
				playlist[0] = last;
			}
		} else if (n & 1) {
			swap(playlist[0], playlist[1]);
		}
	}

	for (int i = 0; i < 5; i++) {
		if (i > 0) cout << ' ';
		cout << playlist[i];
	}
	cout << '\n';
	return 0;
}