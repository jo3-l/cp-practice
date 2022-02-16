#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, a, b;
	cin >> n >> a >> b;
	int a_time = 0, b_time = 0;
	for (int i = 0; i < n; i++) {
		int x, y;
		cin >> x >> y;
		if (x < a) a_time++;
		else a_time += 2;
		if (y < b) b_time++;
		else b_time += 2;
	}

	if (a_time < b_time) cout << "Andrew wins!" << '\n';
	else if (a_time == b_time) cout << "Tie!" << '\n';
	else cout << "Tommy wins!" << '\n';

	return 0;
}