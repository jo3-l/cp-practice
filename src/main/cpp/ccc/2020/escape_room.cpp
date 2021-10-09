#include <bits/stdc++.h>

using namespace std;

constexpr int MR = 1000;
constexpr int MC = 1000;
constexpr int END = -1;

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