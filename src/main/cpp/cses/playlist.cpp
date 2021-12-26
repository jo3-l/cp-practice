#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>

using namespace __gnu_pbds;
using namespace std;

using ull = unsigned long long;

struct chash {
	ull operator()(ull x) const {
		static const int R = chrono::steady_clock::now().time_since_epoch().count();
		x += 0x9e3779b97f4a7c15;
		x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
		x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
		return x ^ (x >> 31) ^ R;
	}
};

int playlist[200'000];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) cin >> playlist[i];
	int i = 0, j = 0;
	gp_hash_table<int, bool, chash> seen;
	int ans = 0;
	while (j < n) {
		if (seen.find(playlist[j]) != seen.end()) {
			seen.erase(playlist[i++]);
			if (i > j) j++;
		} else {
			seen[playlist[j++]] = true;
			ans = max(ans, j - i);
		}
	}
	cout << ans << '\n';
	return 0;
}