#include <bits/stdc++.h>

using namespace std;

const int INF = 0x3f3f3f3f;

enum Cell {
	WALL,
	EMPTY,
	CAMERA,
	INITIAL,

	LEFT,
	RIGHT,
	UP,
	DOWN,

	DEAD,
};

bool is_conveyor(Cell c) { return c >= LEFT && c <= DOWN; }

const int MN = 100;
const int MM = 100;
Cell factory[MN][MM];

pair<int, int> conveyor_destination[MN][MM];
bool conveyor_seen[MN][MM];

int ans[MN * MM];
int cell_to_ans_idx[MN][MM];

int di[]{0, 0, -1, 1};
int dj[]{-1, 1, 0, 0};

int N, M;
bool can_move_to(int i, int j) { return 0 <= i && i < N && 0 <= j && j < M && factory[i][j] != DEAD && factory[i][j] != WALL; }

int cur_step = 1;

int main() {
	memset(cell_to_ans_idx, -1, sizeof(cell_to_ans_idx));
	memset(ans, 0x3f, sizeof(ans));

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			conveyor_destination[i][j] = {-1, -1};
		}
	}

	queue<pair<int, int>> q;
	int empty_cell_cnt = 0;
	for (int i = 0; i < N; i++) {
		string row;
		cin >> row;
		for (int j = 0; j < M; j++) {
			switch (row[j]) {
				case 'W':
					factory[i][j] = WALL;
					break;
				case '.':
					factory[i][j] = EMPTY;
					cell_to_ans_idx[i][j] = empty_cell_cnt++;
					break;
				case 'C':
					factory[i][j] = CAMERA;
					break;
				case 'S':
					factory[i][j] = INITIAL;
					q.push({i, j});
					break;
				case 'L':
					factory[i][j] = LEFT;
					break;
				case 'R':
					factory[i][j] = RIGHT;
					break;
				case 'U':
					factory[i][j] = UP;
					break;
				case 'D':
					factory[i][j] = DOWN;
					break;
			}
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (factory[i][j] == CAMERA) {
				factory[i][j] = DEAD;
				for (int k = j + 1; k < M && factory[i][k] != WALL; k++) {
					if (factory[i][k] == INITIAL) goto done;
					else if (factory[i][k] == EMPTY) factory[i][k] = DEAD;
				}
				for (int k = j - 1; k >= 0 && factory[i][k] != WALL; k--) {
					if (factory[i][k] == INITIAL) goto done;
					else if (factory[i][k] == EMPTY) factory[i][k] = DEAD;
				}
				for (int z = i + 1; z < N && factory[z][j] != WALL; z++) {
					if (factory[z][j] == INITIAL) goto done;
					else if (factory[z][j] == EMPTY) factory[z][j] = DEAD;
				}
				for (int z = i - 1; z >= 0 && factory[z][j] != WALL; z--) {
					if (factory[z][j] == INITIAL) goto done;
					else if (factory[z][j] == EMPTY) factory[z][j] = DEAD;
				}
			} else if (is_conveyor(factory[i][j])) {
				int ci = i, cj = j;
				bool cycle = false;
				while (can_move_to(ci, cj) && is_conveyor(factory[ci][cj])) {
					if (conveyor_seen[ci][cj]) {
						cycle = true;
						break;
					}
					conveyor_seen[ci][cj] = true;
					int dir = factory[ci][cj] - LEFT;
					ci += di[dir];
					cj += dj[dir];
				}
				if (!cycle) conveyor_destination[i][j] = {ci, cj};

				memset(conveyor_seen, false, sizeof(conveyor_seen));
			}
		}
	}

	while (!q.empty()) {
		int sz = q.size();
		while (sz--) {
			int i, j;
			tie(i, j) = q.front();
			q.pop();
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d], nj = j + dj[d];
				if (can_move_to(ni, nj) && is_conveyor(factory[ni][nj])) tie(ni, nj) = conveyor_destination[ni][nj];
				if (can_move_to(ni, nj) && cell_to_ans_idx[ni][nj] != -1) {
					ans[cell_to_ans_idx[ni][nj]] = cur_step;
					q.push({ni, nj});
					factory[ni][nj] = DEAD;
				}
			}
		}
		cur_step++;
	}

done:
	for (int i = 0; i < empty_cell_cnt; i++) cout << (ans[i] == INF ? -1 : ans[i]) << '\n';
	return 0;
}