#include <bits/stdc++.h>

using namespace std;

using ll = long long;

constexpr int MOD = 1e9 + 7;

template <int M> int modpow(int a, int b) {
	ll ans = 1;
	while (b > 0) {
		if (b & 1) ans = (ans * a) % M;
		a = ((ll)a * a) % M;
		b /= 2;
	}
	return ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	while (n--) {
		int a, b;
		cin >> a >> b;
		cout << modpow<MOD>(a, b) << '\n';
	}

	return 0;
}