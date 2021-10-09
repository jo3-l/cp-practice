#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int a, b, c, d;
	cin >> a >> b >> c >> d;
	int cnt = 0;
	for (int i = 0; i * a <= d; i++) {
		for (int j = 0; i * a + j * b <= d; j++) {
			for (int k = 0; i * a + j * b + k * c <= d; k++) {
				if (i || j || k) {
					cout << i << " Brown Trout, " << j << " Northern Pike, " << k
					     << " Yellow Pickerel" << '\n';
					cnt++;
				}
			}
		}
	}

	cout << "Number of ways to catch fish: " << cnt << '\n';
	return 0;
}