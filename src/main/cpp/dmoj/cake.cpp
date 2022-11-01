#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	vector<int> ingredients(n);
	int gcd = -1;
	for (auto& i : ingredients) {
		cin >> i;
		if (gcd == -1)
			gcd = i;
		else
			gcd = __gcd(gcd, i);
	}
	for (int i = 0; i < n; i++) {
		if (i > 0) cout << ' ';
		cout << (ingredients[i] / gcd);
	}
	cout << '\n';
}