#include <bits/stdc++.h>

using namespace std;

const int briefcases[]{100, 500, 1000, 5000, 10'000, 25'000, 50'000, 100'000, 500'000, 1'000'000};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int total = accumulate(begin(briefcases), end(briefcases), 0);
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int k;
		cin >> k;
		total -= briefcases[k - 1];
	}

	int offer;
	cin >> offer;
	cout << ((10 - n) * offer > total ? "deal" : "no deal") << '\n';
	return 0;
}