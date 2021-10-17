#include <bits/stdc++.h>

using namespace std;

constexpr int MK = 101;
int people[MK];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int k, rounds;
	cin >> k >> rounds;

	iota(begin(people) + 1, begin(people) + k + 1, 1);
	int remaining = k;

	while (rounds-- && remaining) {
		int i;
		cin >> i;

		int pos = 1;
		for (int j = 1; j <= remaining; j++) {
			if (j % i != 0) people[pos++] = people[j];
		}
		remaining = pos - 1;
	}

	for (int i = 1; i <= remaining; i++) cout << people[i] << '\n';

	return 0;
}