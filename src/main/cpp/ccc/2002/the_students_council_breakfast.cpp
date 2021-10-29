#include <bits/stdc++.h>

using namespace std;

constexpr int INF = 0x3f3f3f3f;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int p, g, r, o, target;
	cin >> p >> g >> r >> o >> target;
	int cnt = 0;
	int min_n = INF;
	for (int pc = 0; pc * p <= target; pc++) {
		for (int gc = 0; pc * p + gc * g <= target; gc++) {
			for (int rc = 0; pc * p + gc * g + rc * r <= target; rc++) {
				int oc = (target - pc * p - gc * g - rc * r) / o;
				if (pc * p + gc * g + rc * r + oc * o == target) {
					cout << "# of PINK is " << pc << " # of GREEN is " << gc << " # of RED is " << rc
					     << " # of ORANGE is " << oc << '\n';
					cnt++;
					min_n = min(min_n, pc + gc + rc + oc);
				}
			}
		}
	}

	cout << "Total combinations is " << cnt << '.' << '\n';
	cout << "Minimum number of tickets to print is " << min_n << '.' << '\n';
	return 0;
}