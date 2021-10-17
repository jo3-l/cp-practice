#include <bits/stdc++.h>

using namespace std;
using int128 = __int128;

constexpr int UNDEFINED = 0x3f3f3f3f;

struct Cell {
	int val;
	int128 deps; // bitset
};

Cell cells[10][9];

int resolve(int i, int j, int128 seen) {
	if (!cells[i][j].deps) return cells[i][j].val;
	if (seen & ((int128)1 << (i * 9 + j))) return cells[i][j].val = UNDEFINED;
	seen |= (int128)1 << (i * 9 + j);
	for (int n = 0; n < 90 && cells[i][j].val != UNDEFINED; n++) {
		if (cells[i][j].deps & ((int128)1 << n)) {
			int v = resolve(n / 9, n % 9, seen);
			if (v == UNDEFINED) cells[i][j].val = UNDEFINED;
			else cells[i][j].val += v;
		}
	}

	cells[i][j].deps = 0;
	return cells[i][j].val;
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 9; j++) {
			string s;
			cin >> s;
			if (isdigit(s[0])) {
				cells[i][j].val = stoi(s);
			} else {
				for (int k = 0; k < s.size(); k += 3) {
					cells[i][j].deps |= (int128)1 << ((s[k] - 'A') * 9 + s[k + 1] - '1');
				}
			}
		}
	}
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 9; j++) {
			if (j > 0) cout << ' ';
			int v = resolve(i, j, 0);
			if (v == UNDEFINED) cout << '*';
			else cout << v;
		}
		cout << '\n';
	}

	return 0;
}