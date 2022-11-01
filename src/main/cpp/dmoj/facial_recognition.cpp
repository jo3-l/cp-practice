#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	int ans = 0;
	while (n--) {
		string s;
		cin >> s;
		ans += s == "face";
	}
	cout << ans << '\n';
}