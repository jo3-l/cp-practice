#include <bits/stdc++.h>

using namespace std;

constexpr int MC = 100;
int chores[MC];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int t, c;
	cin >> t >> c;
	for (int i = 0; i < c; i++)
		cin >> chores[i];
	sort(begin(chores), begin(chores) + c);
	int i, s = 0;
	for (i = 0; i < c; i++) {
		s += chores[i];
		if (s > t) break;
	}
	cout << i << '\n';
	return 0;
}