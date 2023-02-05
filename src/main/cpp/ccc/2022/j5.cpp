#include <bits/stdc++.h>

using namespace std;

constexpr int INF = numeric_limits<int>::max();

struct point {
	int r, c;
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, t;
	cin >> n >> t;

	vector<point> trees(t);
	for (auto& tree : trees) cin >> tree.r >> tree.c;

	auto solve_given_corner = [&](int corner_r, int corner_c) {
		int local_optimum = min(n - corner_r, n - corner_c);
		for (auto& tree : trees) {
			if (tree.r <= corner_r || tree.c <= corner_c) continue;
			local_optimum = min(local_optimum, max(tree.r - corner_r - 1, tree.c - corner_c - 1));
		};
		return local_optimum;
	};

	int ans = solve_given_corner(0, 0);
	for (auto& left : trees) {
		for (auto& top : trees) {
			int corner_r = min(left.r, top.r), corner_c = min(left.c, top.c);
			ans = max({
			    ans,
			    solve_given_corner(corner_r, corner_c),
			    solve_given_corner(0, corner_c),
			    solve_given_corner(corner_r, 0),
			});
		}
	}
	cout << ans << '\n';
}
