#include <bits/stdc++.h>

using namespace std;

int cnt[42];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	for (int i = 0; i < 10; i++) {
		int n;
		cin >> n;
		cnt[n % 42]++;
	}

	cout << count_if(begin(cnt), end(cnt), [](int c) { return c > 0; }) << '\n';
	return 0;
}