#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 100'000;
int stk[MN];
int len = 0;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int k, sum = 0;
	cin >> k;
	while (k--) {
		int n;
		cin >> n;
		if (n == 0) {
			sum -= stk[--len];
		} else {
			sum += n;
			stk[len++] = n;
		}
	}
	cout << sum << '\n';
	return 0;
}