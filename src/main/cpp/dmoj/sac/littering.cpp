#include <bits/stdc++.h>

using namespace std;

int pieces[100'005];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, k;
	cin >> n >> k;
	for (int i = 0; i < n; i++) cin >> pieces[i];
	nth_element(begin(pieces), begin(pieces) + k, end(pieces), greater<int>{});
	cout << accumulate(begin(pieces), begin(pieces) + k, 0LL) << '\n';

	return 0;
}