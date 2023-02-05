#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;

	int over_40 = 0;
	for (int i = 0; i < n; i++) {
		int pts, fouls;
		cin >> pts >> fouls;
		int rating = pts * 5 - fouls * 3;
		if (rating > 40) over_40++;
	}

	cout << over_40;
	if (over_40 == n) cout << '+';
	cout << '\n';
}
