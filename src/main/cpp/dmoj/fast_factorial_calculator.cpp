#include <bits/stdc++.h>

using namespace std;
using ull = unsigned long long;
using uint = unsigned int;

uint fac(int n) {
	uint ans = 1;
	for (int i = 1; i <= n; i++) ans = (ans * i);
	return ans;
}

void solve() {
	ull n;
	cin >> n;
	cout << (n >= 34 ? 0 : fac(n)) << '\n';
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int t;
	cin >> t;
	while (t--) solve();

	return 0;
}