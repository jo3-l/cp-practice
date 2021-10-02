#include <bits/stdc++.h>

using namespace std;

int xs[4];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	for (int i = 0; i < 4; i++)
		cin >> xs[i];

	if (is_sorted(begin(xs), end(xs), [](int a, int b) { return a <= b; }))
		cout << "Fish Rising" << '\n';
	else if (is_sorted(begin(xs), end(xs), [](int a, int b) { return a >= b; }))
		cout << "Fish Diving" << '\n';
	else if (all_of(begin(xs), end(xs), [&](int x) { return x == xs[0]; }))
		cout << "Fish At Constant Depth" << '\n';
	else
		cout << "No Fish" << '\n';

	return 0;
}