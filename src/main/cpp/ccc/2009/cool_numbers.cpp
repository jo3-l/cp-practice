#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int a, b;
	cin >> a >> b;
	int cnt = 0;
	for (int i = 1; i * i * i <= b; i++) {
		int c = i * i * i;
		if (c >= a) {
			int s = sqrt(c);
			if (s * s == c) cnt++;
		}
	}
	cout << cnt << '\n';
	return 0;
}