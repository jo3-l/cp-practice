#include <bits/stdc++.h>

using namespace std;

int rotated[10];

int rotate(int n) {
	int ans = 0;
	for (; n > 0; n /= 10) {
		int d = n % 10;
		if (rotated[d] == -1) return -1;
		ans = (ans * 10) + rotated[d];
	}
	return ans;
}

int main() {
	memset(rotated, -1, sizeof(rotated));
	rotated[0] = 0;
	rotated[1] = 1;
	rotated[6] = 9;
	rotated[8] = 8;
	rotated[9] = 6;

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int a, b;
	cin >> a >> b;
	int ans = 0;
	for (; a <= b; a++) ans += a == rotate(a);
	cout << ans << '\n';

	return 0;
}