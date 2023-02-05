#include <bits/stdc++.h>

using namespace std;

int calc_max_moves(int a, int b, int c) {
	int moves = 0;
	while (a + 1 != b || b + 1 != c) {
		if (b - a >= c - b) {
			c = a + 1;
			swap(b, c);
		} else {
			a = b + 1;
			swap(a, b);
		}
		moves++;
	}
	return moves;
}

int calc_min_moves(int a, int b, int c) {
	int ab_gap = b - a - 1, bc_gap = c - b - 1;
	int min_gap = min(ab_gap, bc_gap), max_gap = max(ab_gap, bc_gap);
	if (ab_gap == 0 || bc_gap == 0) {
		if (max_gap == 0) return 0; // already done
		if (max_gap == 1) return 1; // A _ B C => A C B
		return 2; // A B _ _ _ C => B _ A _ C => _ _ A B C
	}

	if (min_gap == 1) return 1; // A _ B _ C => _ _ B A C
	return 2; // A _ _ B _ _ C => _ _ _ B _ A C => _ _ _ B C A
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

#ifndef LOCAL
	freopen("herding.in", "r", stdin);
	freopen("herding.out", "w", stdout);
#endif

	int a, b, c;
	cin >> a >> b >> c;

	// sort a, b, c
	if (a > b) swap(a, b);
	if (a > c) swap(a, c);
	if (b > c) swap(b, c);

	cout << calc_min_moves(a, b, c) << '\n' << calc_max_moves(a, b, c) << '\n';
}