#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int rounds;
	cin >> rounds;
	int a = 100, d = 100;
	while (rounds--) {
		int a_r, d_r;
		cin >> a_r >> d_r;
		if (a_r < d_r)
			a -= d_r;
		else if (d_r < a_r)
			d -= a_r;
	}
	cout << a << '\n' << d << '\n';

	return 0;
}