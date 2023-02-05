#include <bits/stdc++.h>

using namespace std;

template <class Fun>
class y_combinator_result {
	Fun fun_;

public:
	template <class T>
	explicit y_combinator_result(T&& fun) : fun_(std::forward<T>(fun)) {}
	template <class... Args>
	decltype(auto) operator()(Args&&... args) {
		return fun_(std::ref(*this), std::forward<Args>(args)...);
	}
};

template <class Fun>
decltype(auto) y_combinator(Fun&& fun) {
	return y_combinator_result<std::decay_t<Fun>>(std::forward<Fun>(fun));
}

struct cell {
	int r, c;

	bool operator==(cell const& other) {
		return r == other.r && c == other.c;
	}
	bool operator!=(cell const& other) {
		return !(*this == other);
	}
};
constexpr cell BAD_CELL{-1, -1};

struct dir {
	int d_r, d_c;
};
constexpr dir L{0, -1}, R{0, 1}, U{-1, 0}, D{1, 0};
array<dir, 4> dirs{L, R, U, D};

constexpr char VISITED = 'V';
constexpr char IN_CAMERA_LINE_OF_SIGHT = 'X';

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, m;
	cin >> n >> m;
	vector<vector<char>> grid(n, vector<char>(m));
	for (auto& row : grid) {
		for (auto& x : row) cin >> x;
	}

	// find start cell and empty cells
	cell start_cell;
	vector<cell> empty_cells;
	vector<vector<int>> min_time(n, vector<int>(m, -1));
	for (int r = 0; r < n; r++) {
		for (int c = 0; c < m; c++) {
			if (grid[r][c] == '.') {
				empty_cells.push_back({r, c});
			} else if (grid[r][c] == 'S') {
				start_cell.r = r;
				start_cell.c = c;
			}
		}
	}

	// mark all cells that cameras can see
	bool can_see_start = false;
	for (int r = 0; r < n; r++) {
		for (int c = 0; c < m; c++) {
			if (grid[r][c] != 'C') continue;
			for (auto d : dirs) {
				int nxt_r = r + d.d_r, nxt_c = c + d.d_c;
				while (grid[nxt_r][nxt_c] != 'W') {
					can_see_start |= grid[nxt_r][nxt_c] == 'S';
					if (grid[nxt_r][nxt_c] == '.') grid[nxt_r][nxt_c] = IN_CAMERA_LINE_OF_SIGHT;
					nxt_r += d.d_r;
					nxt_c += d.d_c;
				}
			}
		}
	}

	if (can_see_start) {
		for (int i = 0; i < empty_cells.size(); i++) cout << -1 << '\n';
		return 0;
	}

	vector<vector<cell>> dest(n, vector<cell>(m, BAD_CELL));
	vector<vector<bool>> conveyor_seen(n, vector<bool>(m));
	auto jump_thru_conveyors = y_combinator([&](auto jump_thru_conveyors, int r, int c) -> cell {
		static unordered_map<char, dir> conveyor_dirs{{'L', L}, {'R', R}, {'U', U}, {'D', D}};

		if (dest[r][c] != BAD_CELL) return dest[r][c];

		auto it = conveyor_dirs.find(grid[r][c]);
		if (it != conveyor_dirs.end()) {
			if (conveyor_seen[r][c]) return BAD_CELL; // loop
			conveyor_seen[r][c] = true;
			return dest[r][c] = jump_thru_conveyors(r + it->second.d_r, c + it->second.d_c);
		}
		return dest[r][c] = cell{r, c};
	});

	queue<cell> q;
	q.push(start_cell);
	grid[start_cell.r][start_cell.c] = VISITED;

	int t = 0;
	while (!q.empty()) {
		int k = q.size();
		while (k--) {
			auto [r, c] = q.front();
			q.pop();
			for (auto d : dirs) {
				auto nxt = jump_thru_conveyors(r + d.d_r, c + d.d_c);
				if (nxt == BAD_CELL) continue; // got into conveyor loop
				if (grid[nxt.r][nxt.c] == '.') {
					grid[nxt.r][nxt.c] = VISITED;
					min_time[nxt.r][nxt.c] = t + 1;
					q.push({nxt.r, nxt.c});
				}
			}
		}

		t++;
	}

	for (auto c : empty_cells) cout << min_time[c.r][c.c] << '\n';
}
