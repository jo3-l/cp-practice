#include <bits/stdc++.h>

using namespace std;

using ull = unsigned long long;

int cnt[200'000];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;

	cnt[0] = 1;
	int sum = 0;
	ull ans = 0;
	for (int i = 0; i < n; i++) {
		int v;
		cin >> v;
		sum = (sum + v) % n;
		if (sum < 0) sum += n;
		ans += cnt[sum];
		cnt[sum]++;
	}
	cout << ans << '\n';
	return 0;
}