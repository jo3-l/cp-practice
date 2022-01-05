# CCC '21 J5 / S2 - Modern Art

**Problem Link:** [DMOJ](https://dmoj.ca/problem/ccc21s2)

## Analysis

Coloring over a square twice leads to it going back to its original color, black. More generally, coloring over a square an odd number of times results in gold; in all other cases it will be black.

Note that the number of times that a square has been colored is equivalent to the number of times its row has been colored, plus the number of times its column has been colored. Therefore, there is no need to track each square individually; it suffices to track the [parity](<https://en.wikipedia.org/wiki/Parity_(mathematics)>) of the times each row and column has been colored.

To obtain the number of squares that are colored gold in the end, we can go through all squares and check whether the parity of the times it's been colored is odd, à la

```
for each square at (i, j)
	if row_colored[i] ^ col_colored[j]:
		gold_squares++
```

This leads to an $O(MN + K)$ solution, which is fast enough.

However there exists a faster solution. Say that $N_R$ rows and $N_C$ columns are colored gold at the moment. Then the answer is simply the number of squares these rows and columns encompass, excluding their intersection, which is

$$
N_R N + N_C M - 2 N_R N_C
$$

(If the correctness of this is unclear, we suggest drawing out some cases on paper.)

## Implementation (C++)

```cpp
#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int m, n, k;
	cin >> m >> n >> k;
	vector<char> row_colored(m + 1), col_colored(n + 1);
	while (k--) {
		char t;
		int x;
		cin >> t >> x;
		if (t == 'R') row_colored[x] ^= 1;
		else col_colored[x] ^= 1;
	}

	int colored_rows = count(row_colored.begin(), row_colored.end(), 1);
	int colored_cols = count(col_colored.begin(), col_colored.end(), 1);
	cout << colored_rows * n + colored_cols * m - 2 * colored_rows * colored_cols << '\n';
	return 0;
}
```

## Time Complexity

The time complexity of this implementation is $O(M + N + K)$, but $O(MN + K)$ also passes as discussed.

## Space Complexity

$O(M + N)$.
