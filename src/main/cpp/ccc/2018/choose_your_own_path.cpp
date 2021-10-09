#include <bits/stdc++.h>

using namespace std;

const int MN = 10'001;
vector<int> graph[MN];

int n;

bool visited[MN];
int reachable = 1;

void dfs(int page) {
	for (int to : graph[page]) {
		if (!visited[to]) {
			visited[to] = true;
			reachable++;
			dfs(to);
		}
	}
}

int shortest_path() {
	if (graph[1].empty()) return 1;
	memset(visited, false, sizeof(visited));
	queue<int> q;
	q.push(1);
	visited[1] = true;
	int step = 1;
	while (!q.empty()) {
		int sz = q.size();
		while (sz--) {
			int page = q.front();
			q.pop();
			for (int to : graph[page]) {
				if (graph[to].empty()) return step + 1;
				if (!visited[to]) {
					visited[to] = true;
					q.push(to);
				}
			}
		}

		step++;
	}

	return -1; // unreachable
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> n;
	for (int i = 1; i <= n; i++) {
		int m;
		cin >> m;
		graph[i].resize(m);
		for (int j = 0; j < m; j++)
			cin >> graph[i][j];
	}

	visited[1] = true;
	dfs(1);
	cout << (reachable == n ? 'Y' : 'N') << '\n';
	cout << shortest_path();

	return 0;
}