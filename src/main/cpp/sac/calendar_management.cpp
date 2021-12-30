#include <bits/stdc++.h>

using namespace std;

pair<int, string> xs[100];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int a, k;
	cin >> a >> k;
	for (int i = 0; i < a; i++) cin >> xs[i].first >> xs[i].second;

	int prev_day = -1;
	while (k--) {
		int d;
		cin >> d;
		for (int i = 0; i < a; i++) {
			if (prev_day < xs[i].first && xs[i].first <= d) cout << xs[i].second << '\n';
		}
		prev_day = d;
	}

	return 0;
}