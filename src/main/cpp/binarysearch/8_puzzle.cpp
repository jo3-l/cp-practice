#include <bits/stdc++.h>

using namespace std;

using ll = long long;

const ll SOLVED = (0LL << 0) | (1LL << 4) | (2LL << 8) | (3LL << 12) | (4LL << 16) | (5LL << 20) | (6LL << 24) | (7LL << 28) | (8LL << 32);
const ll MASK = 0b1111;

const int di[]{1, -1, 0, 0};
const int dj[]{0, 0, 1, -1};

int solve(vector<vector<int>> &board) {
	int used = 0;
	ll encoded = 0;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (used & (1 << board[i][j])) return -1; // dupe
			used |= 1 << board[i][j];
			int p = (i * 3 + j) * 4;
			encoded |= (ll)board[i][j] << p;
		}
	}
	if (used != ((1 << 9) - 1)) return false; // not all nums used
	if (encoded == SOLVED) return 0;
	queue<ll> q;
	unordered_set<ll> seen;
	int swaps = 1;
	q.push(encoded);
	seen.insert(encoded);
	while (!q.empty()) {
		int sz = q.size();
		while (sz--) {
			ll cur = q.front();
			q.pop();
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					int p = (i * 3 + j) * 4;
					int val = (cur >> p) & MASK;
					if (val == 0) {
						for (int d = 0; d < 4; d++) {
							int ni = i + di[d], nj = j + dj[d];
							if (0 <= ni && ni < 3 && 0 <= nj && nj < 3) {
								ll next = cur;
								int np = (ni * 3 + nj) * 4;
								int nval = (cur >> np) & MASK;
								next &= ~(MASK << np);	 // clear other pos
								next |= ((ll)nval << p); // set zero to other val
								if (next == SOLVED) return swaps;
								if (!seen.count(next)) {
									q.push(next);
									seen.insert(next);
								}
							}
						}
						goto done;
					}
				}
			}

		done:;
		}

		swaps++;
	}
	return -1;
}