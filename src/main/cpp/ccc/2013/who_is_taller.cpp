#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 1'000'001;
vector<int> taller_than[MN]; // taller_than(i) = list of people that person i was measured to be taller than
deque<int> dq;
bool vis[MN];

bool is_taller(int a, int b) {
	memset(vis, false, sizeof(vis));
	dq.clear();
	dq.push_back(a);
	while (!dq.empty()) {
		int p = dq.front();
		dq.pop_front();
		for (int q : taller_than[p]) {
			if (q == b) return true;
			if (!vis[q]) {
				dq.push_back(q);
				vis[q] = true;
			}
		}
	}
	return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, m;
	cin >> n >> m;
	while (m--) {
		int x, y;
		cin >> x >> y;
		taller_than[x].push_back(y);
	}

	int p, q;
	cin >> p >> q;
	if (is_taller(p, q))
		cout << "yes" << '\n';
	else if (is_taller(q, p))
		cout << "no" << '\n';
	else
		cout << "unknown" << '\n';

	return 0;
}