#include <bits/stdc++.h>

#define dbg(x) cout << #x << " = " << (x) << '\n';
#define popcnt __builtin_popcount
#define popcnt64 __builtin_popcountll
#define clz __builtin_clz
#define clz64 __builtin_clzll
#define ctz __builtin_ctz
#define ctz64 __builtin_ctzll

using namespace std;

using ull = unsigned long long;
using ll = long long;
using uint128 = __int128;

const int MOD = 1e9 + 7;
const int INF = 0x3f3f3f3f;

template <typename T1, typename T2> struct pair_hash {
	ull operator()(pair<T1, T2> const &p) const {
		static const ull R = chrono::steady_clock::now().time_since_epoch().count();
		return hash<T1>{}(p.first ^ R ^ (p.first >> 16)) ^
		       (hash<T2>{}(p.second ^ R ^ (p.first >> 16)) >> 1);
	}
};

const int MN = 2e6;
bool is_prime[MN + 1];

void sieve() {
	memset(is_prime, true, sizeof(is_prime));
	is_prime[0] = is_prime[1] = false;
	for (int i = 2; i <= MN; i++) {
		if (!is_prime[i] || (ll)i * i > MN) continue;
		for (int j = i * i; j <= MN; j += i)
			is_prime[j] = false;
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