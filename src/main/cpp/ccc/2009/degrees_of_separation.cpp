#include <bits/stdc++.h>

using ll = long long;
using namespace std;

constexpr int MX = 50;
ll friends[MX];

void add_friend(int x, int y) {
	friends[x] |= 1LL << y;
	friends[y] |= 1LL << x;
}

// clang-format off
vector<int> adj[]{
	{},
	{6},
	{6},
	{4, 5, 6, 15},
	{3, 5, 6},
	{3, 4, 6},
	{1, 2, 3, 4, 5, 7},
	{6, 8},
	{7, 9},
	{8, 10, 12},
	{9, 11},
	{10, 12},
	{9, 11, 13},
	{12, 14, 15},
	{13},
	{3, 13},
	{17, 18},
	{16, 18},
	{16, 17}
};
// clang-format on

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (int i = 0; i < 19; i++) {
		for (int j : adj[i]) add_friend(i, j);
	}

	char op;
	for (cin >> op; op != 'q'; cin >> op) {
		switch (op) {
			case 'i': {
				int x, y;
				cin >> x >> y;
				add_friend(x, y);
				break;
			}
			case 'd': {
				int x, y;
				cin >> x >> y;
				friends[x] &= ~(1LL << y);
				friends[y] &= ~(1LL << x);
				break;
			}
			case 'n': {
				int x;
				cin >> x;
				cout << __builtin_popcountll(friends[x]) << '\n';
				break;
			}
			case 'f': {
				int x;
				cin >> x;
				ll all = 0;
				for (int i = 0; i < MX; i++) {
					if (friends[x] & (1LL << i)) all |= friends[i];
				}
				cout << __builtin_popcountll(all & ~((1LL << x) | friends[x])) << '\n';
				break;
			}
			case 's': {
				int x, y;
				cin >> x >> y;
				int degree = 1;

				ll target = 1LL << y;
				ll seen = 1LL << x;
				ll q = 1LL << x;
				while (q) {
					ll nq = 0;
					for (int i = 0; i < MX; i++) {
						if (q & (1LL << i)) {
							if (friends[i] & target) goto found;
							nq |= friends[i] & ~seen;
							seen |= friends[i];
						}
					}
					q = nq;
					degree++;
				}

				cout << "Not connected" << '\n';
				break;
			found:
				cout << degree << '\n';
				break;
			}
		}
	}

	return 0;
}