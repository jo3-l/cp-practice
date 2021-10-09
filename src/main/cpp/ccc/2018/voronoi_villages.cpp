#include <bits/stdc++.h>

using ull = unsigned long long;

using namespace std;

const int MN = 100;
int locs[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> locs[i];
	}
	sort(begin(locs), begin(locs) + n);

	ull min_sz = -1;
	for (int i = 1; i < n - 1; i++) {
		int prev = locs[i - 1], cur = locs[i], next = locs[i + 1];
		min_sz = min(min_sz, ((ull)cur - prev) + ((ull)next - cur));
	}
	cout << (min_sz / 2) << '.' << (5 * (min_sz & 1)) << '\n';
	return 0;
}