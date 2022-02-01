#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, k;
	cin >> n >> k;
	int speed = k;
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		char c;
		cin >> c;
		if (c == 'U') speed = max(speed - 1, 0);
		else if (c == 'D') speed += 1;
		cnt += speed == 0;
	}

	cout << cnt << '\n';
	return 0;
}