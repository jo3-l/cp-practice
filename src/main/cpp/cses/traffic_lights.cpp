#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int x, n;
	cin >> x >> n;
	multiset<int> lens{x};
	set<int> lights{0, x};
	for (int i = 0; i < n; i++) {
		int p;
		cin >> p;
		int lft = *--lights.lower_bound(p), rgt = *lights.upper_bound(p);
		lights.insert(p);

		lens.erase(lens.find(rgt - lft));
		lens.insert(p - lft);
		lens.insert(rgt - p);

		if (i > 0) cout << ' ';
		cout << *lens.rbegin();
	}

	cout << '\n';
	return 0;
}
