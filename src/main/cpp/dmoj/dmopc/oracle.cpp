#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	vector<int> volumes(n);
	for (int &x : volumes) cin >> x;
	int q;
	cin >> q;
	while (q--) {
		int p, q;
		cin >> p >> q;
		p--;
		q--;
		unordered_map<int, int> freq;
		for (int i = p; i <= q; i++) freq[volumes[i]]++;
		int ans = 0;
		for (auto [_, cnt] : freq) ans += (cnt & 1) == 0;
		cout << ans << '\n';
	}

	return 0;
}