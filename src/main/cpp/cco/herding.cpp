#include <bits/stdc++.h>

using namespace std;

constexpr char VIS = '!';

int n, m;
char dir[1000][1000];

const int d_i[]{-1, 0, 1, 0};
const int d_j[]{0, 1, 0, -1};

// get offset into d_i, d_j
int get_offset(char c) {
	switch (c) {
		case 'N':
			return 0;
		case 'E':
			return 1;
		case 'S':
			return 2;
		default:
			return 3;
	}
}

pair<int, int> nxt(int i, int j) {
	int offset = get_offset(dir[i][j]);
	return {i + d_i[offset], j + d_j[offset]};
}

void dfs(int i, int j) {
	if (dir[i][j] == VIS) return;
	auto [nxt_i, nxt_j] = nxt(i, j);
	dir[i][j] = VIS;
	dfs(nxt_i, nxt_j);
	for (int d = 0; d < 4; d++) {
		int nei_i = i + d_i[d], nei_j = j + d_j[d];
		if (0 <= nei_i && nei_i < n && 0 <= nei_j && nei_j < m) {
			if (nxt(nei_i, nei_j) == make_pair(i, j)) dfs(nei_i, nei_j);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) cin >> dir[i][j];
	}

	int ans = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (dir[i][j] != VIS) {
				ans++;
				dfs(i, j);
			}
		}
	}
	cout << ans << '\n';
	return 0;
}
