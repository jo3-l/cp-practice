#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, w, h;
	cin >> n >> w >> h;
	while (n--) {
		int x;
		cin >> x;
		cout << (x * x <= w * w + h * h ? "DA" : "NE") << '\n';
	}

	return 0;
}