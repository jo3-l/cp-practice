#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int n;
	cin >> n;
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		int pts, fouls;
		cin >> pts >> fouls;
		int rating = pts * 5 - fouls * 3;
		if (rating > 40) cnt++;
	}
	cout << cnt;
	if (cnt == n) cout << '+';
	cout << '\n';
	return 0;
}