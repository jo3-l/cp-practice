#include <bits/stdc++.h>

using namespace std;

constexpr int MAX_N = 2'000'000;

vector<bool> run_sieve(int n) {
	vector<bool> prime(n + 1, true);
	prime[0] = prime[1] = false;
	for (int p = 2; p * p <= n; p++) {
		if (!prime[p]) continue;
		for (int i = p * p; i <= n; i += p) prime[i] = false;
	}
	return prime;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	auto prime = run_sieve(MAX_N);
	auto find_pair = [&](int n) {
		if (prime[2] && prime[n * 2 - 2]) return pair{2, n * 2 - 2};
		for (int p1 = 3; p1 < n; p1 += 2) {
			int p2 = n * 2 - p1;
			if (prime[p1] && prime[p2]) return pair{p1, p2};
		}
		assert(false);
	};

	int t;
	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		auto [p1, p2] = find_pair(n);
		cout << p1 << ' ' << p2 << '\n';
	}
}