#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	set<int> available;
	int g, p;
	cin >> g >> p;
	for (int i = 1; i <= g; i++)
		available.insert(i);

	int r;
	for (r = 0; r < p; r++) {
		int d;
		cin >> d;
		auto it = available.upper_bound(d);
		if (it == available.begin()) break;
		available.erase(prev(it));
	}

	cout << r << '\n';
	return 0;
}