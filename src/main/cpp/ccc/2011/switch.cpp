#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int k;
	cin >> k;
	int initial_lights = 0;
	for (int i = 0; i < k; i++) {
		int v;
		cin >> v;
		if (v) initial_lights |= 1 << i;
	}

	if (initial_lights == 0) {
		cout << 0 << '\n';
		return 0;
	}

	int steps = 1;
	unordered_set<int> seen;
	queue<int> q;
	q.push(initial_lights);
	seen.insert(initial_lights);
	while (!q.empty()) {
		int sz = q.size();
		while (sz--) {
			int lights = q.front();
			q.pop();
			for (int i = 0; i < k; i++) {
				if (!(lights & (1 << i))) {
					int lo = i - 1;
					while (lo >= 0 && lights & (1 << lo))
						lo--;
					lo++;
					int hi = i + 1;
					while (hi < k && lights & (1 << hi))
						hi++;
					hi--;
					if (hi - lo + 1 < 4) {
						int b = lights | (1 << i);
						if (!seen.count(b)) {
							seen.insert(b);
							q.push(b);
						}
						continue;
					}

					int mask = ((1 << (hi + 1)) - 1) & ~((1 << lo) - 1);
					int next = lights & ~mask;
					if (next == 0) {
						cout << steps << '\n';
						return 0;
					}

					if (!seen.count(next)) {
						seen.insert(next);
						q.push(next);
					}
				}
			}
		}

		steps++;
	}

	return 0;
}