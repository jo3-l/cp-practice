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

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, x;
	cin >> n >> x;
	gp_hash_table<ull, ull, chash> seen;
	seen[0]++;
	ull sum = 0;
	ull cnt = 0;
	for (int i = 0; i < n; i++) {
		ull v;
		cin >> v;
		sum += v;
		auto it = seen.find(sum - x);
		if (it != seen.end()) cnt += it->second;
		seen[sum]++;
	}

	cout << cnt << '\n';
	return 0;
}