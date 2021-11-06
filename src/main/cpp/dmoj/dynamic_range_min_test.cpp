#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 100'000;
int tree[MN * 2];

constexpr int INF = 0x3f3f3f3f;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++) cin >> tree[i + n];
	for (int i = n - 1; i > 0; i--) tree[i] = min(tree[i * 2], tree[i * 2 + 1]);
	while (m--) {
		char op;
		int i, j;
		cin >> op >> i >> j;
		if (op == 'M') {
			tree[i += n] = j;
			for (; i > 1; i /= 2) tree[i / 2] = min(tree[i], tree[i ^ 1]);
		} else {
			int ans = INF;
			for (i += n, j += n + 1; i < j; i /= 2, j /= 2) {
				if (i & 1) ans = min(ans, tree[i++]);
				if (j & 1) ans = min(ans, tree[--j]);
			}
			cout << ans << '\n';
		}
	}

	return 0;
}
