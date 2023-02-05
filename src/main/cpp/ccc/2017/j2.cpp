#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, k;
	cin >> n >> k;

	static array<int, 6> multipliers{11, 11, 111, 1111, 11'111, 111'111};
	cout << n * multipliers[k] << '\n';
}