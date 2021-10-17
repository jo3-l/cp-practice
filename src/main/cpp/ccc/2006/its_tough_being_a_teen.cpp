#include <bits/stdc++.h>

using namespace std;

int tasks[]{1, 2, 3, 4, 5, 6, 7};
vector<pair<int, int>> reqs{{1, 7}, {1, 4}, {2, 1}, {3, 4}, {3, 5}};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int x, y;
	for (cin >> x >> y; x; cin >> x >> y)
		reqs.push_back({x, y});
	do {
		int i;
		for (i = 0; i < reqs.size(); i++) {
			auto r = reqs[i];
			int a = distance(begin(tasks), find(begin(tasks), end(tasks), r.first));
			int b = distance(begin(tasks), find(begin(tasks), end(tasks), r.second));
			if (a > b) break;
		}

		if (i >= reqs.size()) {
			for (int j = 0; j < 7; j++) {
				if (j > 0) cout << ' ';
				cout << tasks[j];
			}
			cout << '\n';
			return 0;
		}
	} while (next_permutation(begin(tasks), end(tasks)));

	cout << "Cannot complete these tasks. Going to bed." << '\n';
	return 0;
}