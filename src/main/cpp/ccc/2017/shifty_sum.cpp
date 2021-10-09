#include <bits/stdc++.h>

using namespace std;

int table[]{1, 11, 111, 1111, 11'111, 111'111};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, k;
	cin >> n >> k;
	cout << n * table[k] << '\n';

	return 0;
}