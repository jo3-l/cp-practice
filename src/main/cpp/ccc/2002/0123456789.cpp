#include <bits/stdc++.h>

using namespace std;

constexpr int S = 8;
constexpr int N = 9;

// clang-format off
const int state[] {
    S, 1, S, 1, S, 1, S, N,
    2, S, S, S, S, S, 3, N,
    2, S, S, S, S, S, 3, N,
    2, S, S, S, S, S, 3, N,
    S, 4, S, 4, S, 4, S, N,
    5, S, S, S, S, S, 6, N,
    5, S, S, S, S, S, 6, N,
    5, S, S, S, S, S, 6, N,
    S, 7, S, 7, S, 7, S, N,
};
// clang-format on

const int segments[]{
    (1 << 1) | (1 << 2) | (1 << 3) | (1 << 5) | (1 << 6) | (1 << 7),
    (1 << 3) | (1 << 6),
    (1 << 1) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 7),
    (1 << 1) | (1 << 3) | (1 << 4) | (1 << 6) | (1 << 7),
    (1 << 2) | (1 << 3) | (1 << 4) | (1 << 6),
    (1 << 1) | (1 << 2) | (1 << 4) | (1 << 6) | (1 << 7),
    (1 << 1) | (1 << 2) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7),
    (1 << 1) | (1 << 3) | (1 << 6),
    (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7),
    (1 << 1) | (1 << 2) | (1 << 3) | (1 << 4) | (1 << 6) | (1 << 7),
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	int segment = segments[n];
	string res;
	for (int s : state) {
		if (s == N) {
			while (!res.empty() && res[res.size() - 1] == ' ') res.pop_back();
			res += '\n';
		} else if (segment & (1 << s)) {
			res += '*';
		} else {
			res += ' ';
		}
	}
	cout << res;
	return 0;
}
