#include <bits/stdc++.h>

using namespace std;

char moves[30'000];
char backyard[375][80];

struct IntPairHash {
	size_t operator()(const pair<int, int> c) const { return hash<int>{}(c.first) * 31 + hash<int>{}(c.second); }
};
unordered_set<pair<int, int>, IntPairHash> offsets;

const int di[]{-1, 0, 1, 0};
const int dj[]{0, 1, 0, -1};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int r, c;
	cin >> r >> c;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) cin >> backyard[i][j];
	}

	int move_cnt;
	cin >> move_cnt;
	for (int i = 0; i < move_cnt; i++) cin >> moves[i];

	for (int d = 0; d < 4; d++, offsets.clear()) {
		int cur_d = d;
		int d_i = 0, d_j = 0;
		for (int k = 0; k < move_cnt; k++) {
			switch (moves[k]) {
				case 'F':
					d_i += di[cur_d];
					d_j += dj[cur_d];
					offsets.insert({d_i, d_j});
					break;
				case 'L':
					if (--cur_d < 0) cur_d += 4;
					break;
				case 'R':
					cur_d = (cur_d + 1) % 4;
					break;
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int fi = i + d_i, fj = j + d_j;
				if (fi < 0 || fi >= r || fj < 0 || fj >= c || backyard[fi][fj] != '.') continue;
				if (backyard[i][j] == 'X') continue;
				bool good = true;
				for (auto o : offsets) {
					int ci = i + o.first, cj = j + o.second;
					if (ci < 0 || ci >= r || cj < 0 || cj >= c || backyard[ci][cj] == 'X') {
						good = false;
						break;
					}
				}
				if (good) backyard[fi][fj] = '*';
			}
		}
	}

	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) cout << backyard[i][j];
		cout << '\n';
	}
	return 0;
}