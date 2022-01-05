# CCC '20 J5 / S2 - Escape Room

**Problem Link:** [DMOJ](https://dmoj.ca/problem/ccc20s2)

## Analysis

We model the room as a [directed graph](https://en.wikipedia.org/wiki/Directed_graph) where each vertex is a cell. Given an arbitrary cell with value $x$ we add an outgoing edge to the vertex for cell $(a, b)$ where $a \cdot b = x$ for all applicable $a, b$. We can precompute the edges of all vertices using a procedure similar to finding all divisors of all numbers in a range $[1, n]$ in $\mathcal{O}(n \log n)$ time.

The problem then simplifies to finding the shortest path from vertex $(1, 1)$ to $(M, N)$. As the graph is unweighted we can use a standard [breadth-first search](https://en.wikipedia.org/wiki/Breadth-first_search).

As we want to find the shortest path, there is an optimization we can make; that is, there is no need to have a vertex for each cell. Say we have two cells with the same value, e.g., the two $3s$ in the following room:

```
[3] 10  8   14

1   11  12  12

6   2   [3]  9
```

Due to the fact that the outgoing edges of a cell are determined solely based on their values, if we have visited one of the cells with value $3$, there is no need to visit the other one.

In order to make this optimization, there is one small modification we need to make; in order to differentiate the end cell when using values as vertices, we need to give it a marker value, e.g., `-1` so we know when to stop our search.

## Implementation (C++)

```cpp
#include <bits/stdc++.h>

using namespace std;

constexpr int LAST = -1; // marker value for last cell
constexpr int MM = 1000, MN = 1000;
constexpr int MX = 1'000'000;

int room[MM + 1][MN + 1];
vector<pair<int, int>> adj[MX + 1];
int m, n;

void fill_adj() {
	for (int a = 1; a <= m; a++) {
		for (int x = a; x <= min(MX, a * n); x += a) {
			int b = x / a;
			adj[x].push_back({a, b});
			adj[x].push_back({b, a});
		}
	}
}

bool search() {
	// special case; room consists of 1 cell so we're already at the end
	if (m == 1 && n == 1) return true;
	queue<int> q;
	q.push(room[1][1]);
	unordered_set<int> seen{room[1][1]};
	while (!q.empty()) {
		int x = q.front();
		q.pop();
		for (auto nxt : adj[x]) {
			int nx = room[nxt.first][nxt.second];
			if (nx == LAST) return true;
			if (!seen.count(nx)) {
				q.push(nx);
				seen.insert(nx);
			}
		}
	}
	return false;
}

int main() {
	cin >> m >> n;
	for (int i = 1; i <= m; i++) {
		for (int j = 1; j <= n; j++) cin >> room[i][j];
	}
	room[m][n] = LAST;

	fill_adj();
	cout << (search() ? "yes" : "no") << '\n';
	return 0;
}
```

## Time Complexity

The performance of this solution is bottlenecked by precomputing all the factors (i.e., the edges of the vertices) at the beginning, which is $\mathcal{O}(MN \log MN)$.

## Space Complexity

Similar to time complexity -- $\mathcal{O}(MN \log MN)$.
