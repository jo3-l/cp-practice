#include <bits/stdc++.h>

using namespace std;

int seg[2 * 200'000];
int n;

void upd(int i, int v) {
	seg[i += n] = v;
	for (; i > 1; i /= 2) seg[i / 2] = min(seg[i], seg[i ^ 1]);
}

// [l, r)
int query(int l, int r) {
	int ans = numeric_limits<int>::max();
	for (l += n, r += n; l < r; l /= 2, r /= 2) {
		if (l & 1) ans = min(ans, seg[l++]);
		if (r & 1) ans = min(ans, seg[--r]);
	}
	return ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int q;
	cin >> n >> q;
	for (int i = 0; i < n; i++) cin >> seg[i + n];
	for (int i = n - 1; i > 0; i--) seg[i] = min(seg[i * 2], seg[i * 2 + 1]);

	while (q--) {
		int t, x, y;
		cin >> t >> x >> y;
		if (t == 1) upd(x - 1, y);
		else cout << query(x - 1, y) << '\n';
	}

	return 0;
}