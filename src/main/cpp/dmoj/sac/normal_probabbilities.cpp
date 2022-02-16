#include <bits/stdc++.h>

using namespace std;

const double prbs[]{1.0, 0.8, 0.6, 0.4, 0.2};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	double prb = 1.0;
	while (n--) {
		char c;
		cin >> c;
		prb *= prbs[c - 'A'];
	}

	cout << setprecision(10) << fixed << prb << '\n';
	return 0;
}