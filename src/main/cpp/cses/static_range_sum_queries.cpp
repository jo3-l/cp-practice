#include <bits/stdc++.h>

using namespace std;
using ll = long long;

ll pfs[200'001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, q;
	cin >> n >> q;
	for (int i = 1; i <= n; i++) {
		cin >> pfs[i];
		pfs[i] += pfs[i - 1];
	}

	while (q--) {
		int a, b;
		cin >> a >> b;
		cout << pfs[b] - pfs[a - 1] << '\n';
	}

	return 0;
}