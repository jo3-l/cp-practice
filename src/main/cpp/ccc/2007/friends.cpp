#include <bits/stdc++.h>

using namespace std;

constexpr int MX = 10'000;
int assigned[MX];
bool seen[MX];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	while (n--) {
		int x, y;
		cin >> x >> y;
		assigned[x] = y;
	}

	int x, y;
	for (cin >> x >> y; x; cin >> x >> y) {
		memset(seen, false, sizeof(seen));
		seen[0] = true;
		int dist = 0;
		int cur = x;
		while (!seen[assigned[cur]] && assigned[cur] != y) {
			seen[cur] = true;
			cur = assigned[cur];
			dist++;
		}

		if (assigned[cur] == y) cout << "Yes " << dist << '\n';
		else cout << "No" << '\n';
	}

	return 0;
}