#include <bits/stdc++.h>

using namespace std;
using ll = long long;

int cnt1[26], cnt2[26];

ll cross() {
	ll ans = 0;
	for (int i = 0; i < 26; i++) ans += (ll)cnt1[i] * cnt2[i];
	return ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int s_n, t_n;
	cin >> s_n >> t_n;
	while (s_n--) {
		char c;
		cin >> c;
		cnt1[c - 'A']++;
	}
	while (t_n--) {
		char c;
		cin >> c;
		cnt2[c - 'A']++;
	}

	ll ans = cross();
	for (int src = 0; src < 26; src++) {
		for (int dst = 0; dst < 26; dst++) {
			if (cnt2[src] == 0) continue;
			cnt2[dst]++;
			cnt2[src]--;
			ans = max(ans, cross());
			cnt2[dst]--;
			cnt2[src]++;
		}
	}

	cout << ans << '\n';
	return 0;
}