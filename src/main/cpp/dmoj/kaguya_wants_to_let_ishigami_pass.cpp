#include <bits/stdc++.h>

using namespace std;

int students[10'000];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, k;
	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < k; j++) {
			char c;
			cin >> c;
			students[i] |= (c == 'T') << j;
		}
	}

	int mc = 0;
	for (int ans = 0; ans < (1 << k); ans++) {
		int c = 0x3f3f3f3f;
		for (int i = 0; i < n; i++) {
			int lc = 0;
			for (int j = 0; j < k; j++) lc += (students[i] & (1 << j)) == (ans & (1 << j));
			c = min(c, lc);
		}
		mc = max(mc, c);
	}
	cout << mc << '\n';

	return 0;
}