#include <bits/stdc++.h>

using namespace std;

int n, s;
unordered_map<int, int> points;
vector<int> participants[2005];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	cin >> n >> s;
	int grp_cnt = n / s;
	for (int grp = 0; grp < grp_cnt; grp++) {
		participants[grp].resize(s);
		for (auto& x : participants[grp]) cin >> x;
	}

	int matches = ((s - 1) * n) / 2;
	for (int i = 0; i < matches; i++) {
		int a, b;
		char r;
		cin >> a >> b >> r;
		if (r == 'W') {
			// a win
			points[a] += 3;
		} else if (r == 'L') {
			// b win
			points[b] += 3;
		} else if (r == 'T') {
			// a and b tie
			points[a]++;
			points[b]++;
		}
	}

	int k;
	cin >> k;
	for (int grp = 0; grp < grp_cnt; grp++) {
		auto& group = participants[grp];
		sort(group.begin(), group.end(), [&](int a, int b) {
			int a_pt = points[a];
			int b_pt = points[b];
			return a_pt > b_pt || (a_pt == b_pt && a < b);
		});
		if (grp > 0) cout << ' ';
		cout << group[k - 1];
	}

	cout << '\n';
	return 0;
}