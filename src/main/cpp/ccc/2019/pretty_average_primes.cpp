#include <bits/stdc++.h>

using ll = long long;
using namespace std;

const int MN = 2e6;
bool is_prime[MN + 1];

void sieve() {
	memset(is_prime, true, sizeof(is_prime));
	is_prime[0] = is_prime[1] = false;
	for (int i = 2; i <= MN; i++) {
		if (!is_prime[i] || (ll)i * i > MN) continue;
		for (int j = i * i; j <= MN; j += i) is_prime[j] = false;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	sieve();

	// Sieve of Eratosthenes on [0, 2 million] and then a simple linear
	// search on all possible pairs than sum to the target.
	int t;
	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		n *= 2;
		for (int a = 2; a <= n - 2; a++) {
			int b = n - a;
			if (is_prime[a] && is_prime[b]) {
				cout << a << ' ' << b << '\n';
				break;
			}
		}
	}
	return 0;
}