#include <bits/stdc++.h>

using namespace std;

constexpr int MR = 25, MC = 25;
char floor_plan[MR][MC];

int r, c;

const int di[]{1, -1, 0, 0};
const int dj[]{0, 0, -1, 1};

int get_room_size(int i, int j) {
	int s = 1;
	for (int d = 0; d < 4; d++) {
		int ni = i + di[d], nj = j + dj[d];
		if (0 <= ni && ni < r && 0 <= nj && nj < c && floor_plan[ni][nj] == '.') {
			floor_plan[ni][nj] = 'I';
			s += get_room_size(ni, nj);
		}
	}
	return s;
}

int rooms[MR * MC];
int room_count;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int f;
	cin >> f >> r >> c;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) cin >> floor_plan[i][j];
	}

	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (floor_plan[i][j] == '.') {
				floor_plan[i][j] = 'I';
				rooms[room_count++] = get_room_size(i, j);
			}
		}
	}

	sort(begin(rooms), begin(rooms) + room_count, [](int a, int b) { return a > b; });
	int i;
	for (i = 0; i < room_count; i++) {
		if (f - rooms[i] < 0) break;
		f -= rooms[i];
	}

	cout << i << " room";
	if (i != 1) cout << 's';
	cout << ", " << f << " square metre(s) left over" << '\n';

	return 0;
}