#include <bits/stdc++.h>

#define dbg(x) cout << #x << " = " << (x) << '\n';
#define popcnt __popcount
#define popcnt64 __popcountll
#define clz __builtin_clz
#define clz64 __builtin_clzll
#define ctz __builtin_ctz
#define ctz64 __builtin_ctzll

using namespace std;

using ll = long long;
using uint128 = __int128;

const int MOD = 1e9 + 7;
const int INF = 1e9;

template <typename T1, typename T2> struct pair_hash {
	size_t operator()(pair<T1, T2> const &p) const {
		return hash<T1>(p.first) ^ hash<T2>(p.second);
	}
};

const int MR = 1000;
const int MC = 1000;
const int END = -1;

int matrix[MR][MC];

int K, C;

bool solve() {
	// breadth-first search. instead of coordinates, we store values.
	set<int> seen;
	queue<int> q;
	if (matrix[0][0] == END) return true;
	q.push(matrix[0][0]);
	while (!q.empty()) {
		int v = q.front();
		q.pop();
		for (int f1 = 1; f1 <= K; f1++) {
			int f2 = v / f1;
			if (1 <= f2 && f2 <= C && f1 * f2 == v) {
				int jmp = matrix[f1 - 1][f2 - 1];
				if (jmp == END) return true;
				if (!seen.count(jmp)) {
					seen.insert(jmp);
					q.push(jmp);
				}
			}
		}
	}
	return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> K >> C;
	for (int i = 0; i < K; i++) {
		for (int j = 0; j < C; j++)
			cin >> matrix[i][j];
	}
	// patch the end cell.
	matrix[K - 1][C - 1] = END;

	cout << (solve() ? "yes" : "no") << endl;
	return 0;
}