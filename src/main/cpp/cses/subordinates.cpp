#include <bits/stdc++.h>

using namespace std;

vector<int> sub[200'001];
int memo[200'001];

int calc_sub(int b) {
	if (memo[b] == -1) {
		memo[b] = 0;
		for (int s : sub[b]) memo[b] += calc_sub(s) + 1;
	}
	return memo[b];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	for (int i = 2; i <= n; i++) {
		int b;
		cin >> b;
		sub[b].push_back(i);
	}

	memset(memo, -1, sizeof(memo));
	memo[1] = n - 1;
	for (int i = 1; i <= n; i++) cout << calc_sub(i) << ' ';
	cout << '\n';

	return 0;
}