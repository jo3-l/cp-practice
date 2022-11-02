#include <bits/stdc++.h>

using namespace std;

constexpr int INF = 0x3f3f3f3f;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	vector<int> names(n);
	for (auto& name : names) cin >> name;

	int a, b;
	cin >> a >> b;
	sort(names.begin(), names.end());

	int best = -1;
	int best_score = -1;
	auto process = [&](int p) {
		if (p < a || p > b) return;
		auto it = lower_bound(names.begin(), names.end(), p + 1);
		int score = min(*it - p, p - *prev(it));
		if (score > best_score) {
			best_score = score;
			best = p;
		}
	};

	names.insert(names.begin(), -INF);
	names.insert(names.end(), INF);
	for (int i = 0; i < names.size() - 1; i++) {
		int mid = (names[i] + names[i + 1]) / 2;
		if (mid & 1) {
			process(mid);
		} else {
			// check adjacent odd nums
			process(mid - 1);
			process(mid + 1);
		}
	}

	process(a & 1 ? a : a + 1);
	process(b & 1 ? b : b - 1);
	cout << best << '\n';
}