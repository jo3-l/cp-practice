#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int p, n, r;
	cin >> p >> n >> r;

	int d = 0;
	for (int s = n, k = r; s <= p; d++) {
		s += n * k;
		k *= r;
	}
	cout << d << '\n';
}