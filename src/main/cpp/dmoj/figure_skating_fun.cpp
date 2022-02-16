#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 1'000'005;
int all[MN];
int pfs[MN];
int rfs[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) cin >> all[i];
	for (int i = 1; i <= n; i++) pfs[i] = pfs[i - 1] + all[i];
	for (int i = n; i >= 1; i--) rfs[i] = rfs[i + 1] + all[i];
	for (int i = 1; i <= n; i++) {
		if (pfs[i] == rfs[i + 1]) {
			cout << i << '\n';
			return 0;
		}
	}
	cout << "Andrew is sad." << '\n';
	return 0;
}