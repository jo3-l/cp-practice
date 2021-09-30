#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 100;
int dmojistan[MN];
int pegland[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int type, n;
	cin >> type >> n;
	for (int i = 0; i < n; i++)
		cin >> dmojistan[i];
	for (int i = 0; i < n; i++)
		cin >> pegland[i];
	sort(begin(dmojistan), begin(dmojistan) + n);
	sort(begin(pegland), begin(pegland) + n);
	int r = 0;
	if (type == 1) {
		for (int i = 0; i < n; i++)
			r += max(dmojistan[i], pegland[i]);
	} else {
		for (int d = 0, p = n - 1; d < n; d++, p--)
			r += max(dmojistan[d], pegland[p]);
	}
	cout << r << '\n';

	return 0;
}