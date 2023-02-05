#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int k, rounds;
	cin >> k >> rounds;
	vector<int> people(k);
	iota(people.begin(), people.end(), 1);

	while (rounds--) {
		int r;
		cin >> r;

		auto it = people.begin();
		for (int i = 0; i < people.size(); i++) {
			if ((i + 1) % r != 0) *it++ = people[i];
		}
		people.erase(it, people.end());
	}
	for (int p : people) cout << p << '\n';
}