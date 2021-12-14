#include <bits/stdc++.h>

using namespace std;

template <class Fun> class y_combinator_result {
	Fun fun_;

public:
	template <class T> explicit y_combinator_result(T &&fun) : fun_(std::forward<T>(fun)) {}
	template <class... Args> decltype(auto) operator()(Args &&...args) { return fun_(std::ref(*this), std::forward<Args>(args)...); }
};

template <class Fun> decltype(auto) y_combinator(Fun &&fun) { return y_combinator_result<std::decay_t<Fun>>(std::forward<Fun>(fun)); }

const int dx[]{1, -1, 0, 0};
const int dy[]{0, 0, 1, -1};

int solve(vector<vector<int>> &a, vector<vector<int>> &b) {
	int r = a.size(), c = a[0].size();
	vector<vector<int>> m(r, vector<int>(c));
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) m[i][j] = a[i][j] | b[i][j];
	}

	auto flood = y_combinator([&](auto flood, int i, int j) -> bool {
		bool good = true;
		good &= a[i][j] == b[i][j];
		for (int d = 0; d < 4; d++) {
			int n_i = i + dy[d], n_j = j + dx[d];
			if (0 <= n_i && n_i < r && 0 <= n_j && n_j < c) {
				if (m[n_i][n_j]) {
					m[n_i][n_j] = 0;
					good &= flood(n_i, n_j);
				}
			}
		}
		return good;
	});
	int n = 0;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (m[i][j]) {
				m[i][j] = 0;
				n += flood(i, j);
			}
		}
	}
	return n;
}