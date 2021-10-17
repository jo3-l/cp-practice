#include <bits/stdc++.h>

using namespace std;

const string places[]{"Ottawa", "Victoria", "Edmonton", "Winnipeg", "Toronto", "Halifax", "St. John's"};
const int offsets[]{0, -3 * 60, -2 * 60, -60, 0, 60, 90};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int t;
	cin >> t;
	int baseline = (t / 100) * 60 + t % 100;
	for (int i = 0; i < 7; i++) {
		int nt = baseline + offsets[i];
		if (nt < 0) nt += 24 * 60;
		else if (nt >= 24 * 60) nt -= 24 * 60;
		cout << (nt / 60) * 100 + (nt % 60) << " in " << places[i] << '\n';
	}

	return 0;
}