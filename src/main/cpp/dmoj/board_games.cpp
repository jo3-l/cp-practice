#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 1e7 + 1;
bitset<MN> seen;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, m;
	cin >> n >> m;
	if (n == m) {
		cout << 0 << '\n';
		return 0;
	}
	int moves = 1;
	deque<int> dq;
	dq.push_back(n);
	while (!dq.empty()) {
		int sz = dq.size();
		while (sz--) {
			int cur = dq.front();
			dq.pop_front();

			auto make_move = [&](int to) {
				if (0 <= to && to < MN && !seen[to]) {
					seen[to] = true;
					dq.push_back(to);
				}
			};
			if (3 * cur == m) goto done;
			make_move(3 * cur);
			if (cur - 1 == m) goto done;
			make_move(cur - 1);
			if (cur - 3 == m) goto done;
			make_move(cur - 3);
			if (!(cur & 1)) {
				if (cur / 2 == m) goto done;
				make_move(cur / 2);
			}
		}
		moves++;
	}
done:
	cout << moves << '\n';
	return 0;
}