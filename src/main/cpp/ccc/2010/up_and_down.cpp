#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int a, b, c, d, s;
	cin >> a >> b >> c >> d >> s;
	int n_l = s % (a + b);
	int dn = abs((s / (a + b)) * (a - b) + min(a, n_l) - max(n_l - a, 0));
	int b_l = s % (c + d);
	int db = abs((s / (c + d)) * (c - d) + min(c, b_l) - max(b_l - c, 0));
	if (dn > db) cout << "Nikky" << '\n';
	else if (dn == db) cout << "Tied" << '\n';
	else cout << "Byron" << '\n';
	return 0;
}