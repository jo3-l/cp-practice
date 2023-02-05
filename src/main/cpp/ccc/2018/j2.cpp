#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	string yesterday, today;
	cin >> n >> yesterday >> today;

	int cnt = 0;
	for (int i = 0; i < n; i++) {
		if (yesterday[i] == 'C' && today[i] == 'C') cnt++;
	}
	cout << cnt << '\n';
}