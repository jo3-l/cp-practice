#include <bits/stdc++.h>

#define dbg(x) cout << #x << " = " << (x) << '\n';
#define popcnt __popcount
#define popcnt64 __popcountll
#define clz __builtin_clz
#define clz64 __builtin_clzll
#define ctz __builtin_ctz
#define ctz64 __builtin_ctzll

using namespace std;

using ull = unsigned long long;
using ll = long long;
using uint128 = __int128;

const int MOD = 1e9 + 7;
const int INF = 1e9;

template <typename T1, typename T2> struct pair_hash {
	ull operator()(pair<T1, T2> const &p) const {
		static const ull R =
		    chrono::steady_clock::now().time_since_epoch().count();
		return hash<T1>{}(p.first ^ R ^ (p.first >> 16)) ^
		       (hash<T2>{}(p.second ^ R ^ (p.first >> 16)) >> 1);
	}
};

const int P = 31;
const int Q = 101;
const int Z = 26;

int needle_freq[Z];
int haystack_window_freq[Z];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string needle, haystack;
	cin >> needle >> haystack;
	if (needle.size() > haystack.size()) {
		cout << 0 << '\n';
		return 0;
	}

	// Let's use a sliding window approach combined with string hashing.
	// For each |N|-length substring of H, compute its frequency array, and
	// compare it with the frequency array of N. If they're the same, then
	// that substring is a valid answer.
	//
	// To handle duplicates, we hash the strings using a polynomial hash and
	// store them in a set when an answer is found. Then, at the end, the
	// answer is just the size of the set.
	//
	// To reduce the possibility of hash collisions, we use a pair of hashes
	// with different powers (31 / 101).
	unordered_set<pair<int, int>, pair_hash<int, int>> seen;
	ull needle_hsh_p = 0;
	ull needle_hsh_q = 0;
	ull haystack_window_hsh_p = 0;
	ull haystack_window_hsh_q = 0;
	ull p_max = 1;
	ull q_max = 1;
	for (int i = 0; i < needle.size(); i++) {
		int nc = needle[i] - 'a';
		needle_hsh_p = (needle_hsh_p * P) + nc;
		needle_hsh_q = (needle_hsh_q * Q) + nc;
		needle_freq[nc]++;

		int hc = haystack[i] - 'a';
		haystack_window_hsh_p = (haystack_window_hsh_p * P) + hc;
		haystack_window_hsh_q = (haystack_window_hsh_q * Q) + hc;
		haystack_window_freq[hc]++;

		if (i > 0) {
			p_max *= P;
			q_max *= Q;
		}
	}

	auto check = [&]() {
		if (memcmp(needle_freq, haystack_window_freq,
			   sizeof(needle_freq)) == 0)
			seen.insert(
			    {haystack_window_hsh_p, haystack_window_hsh_q});
	};
	check();
	for (int i = 1, j = needle.size(); j < haystack.size(); i++, j++) {
		int pc = haystack[i - 1] - 'a';
		int c = haystack[j] - 'a';
		haystack_window_hsh_p =
		    (haystack_window_hsh_p - pc * p_max) * P + c;
		haystack_window_hsh_q =
		    (haystack_window_hsh_q - pc * q_max) * Q + c;
		haystack_window_freq[c]++;
		haystack_window_freq[pc]--;
		check();
	}

	cout << seen.size() << '\n';
	return 0;
}