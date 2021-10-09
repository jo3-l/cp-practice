#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int a, b;
	cin >> a >> b;
	int i;
	for (i = 3; a >= b; i++) {
		a -= b;
		swap(a, b);
	}

	cout << i - 1 << '\n';
	return 0;
}