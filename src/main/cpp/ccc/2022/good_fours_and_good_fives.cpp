#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	int cnt = 0;
	for (int fives = 0; fives <= n / 5; fives++) {
		cnt += (n - fives * 5) % 4 == 0;
	}
	cout << cnt << '\n';
	return 0;
}