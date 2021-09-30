#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string yesterday, today;
	int n;
	cin >> n >> yesterday >> today;
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		if (yesterday[i] == 'C' && today[i] == 'C') cnt++;
	}
	cout << cnt << '\n';

	return 0;
}