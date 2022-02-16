#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>

using namespace std;
using namespace __gnu_pbds;

using ll = long long;
using ull = unsigned long long;

struct CustomHash {
	ull operator()(pair<ll, ll> x) const {
		return hash_ull(x.first) * 31 + hash_ull(x.second);
	}

	ull hash_ull(ull x) const {
		// http://xorshift.di.unimi.it/splitmix64.c
		static const ull R = chrono::steady_clock::now().time_since_epoch().count();
		x += 0x9e3779b97f4a7c15;
		x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
		x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
		return x ^ (x >> 31) ^ R;
	}
};
gp_hash_table<pair<ull, ull>, null_type, CustomHash> seen;

constexpr ll P = 31;
constexpr ll Q = 47;
constexpr ll MOD = 1e9 + 7;

int needle_freq[26];
int window_freq[26];

template <ll Pow>
struct PolyHash {
	PolyHash(int len) : v(), max_pow(1) {
		for (int i = 1; i < len; i++) max_pow = (max_pow * Pow) % MOD;
	}

	void push_back(char c) {
		v = (v * Pow) % MOD;
		v = (v + ll(c - 'a')) % MOD;
	}

	void pop_front(char c) {
		v = (v - ll(c - 'a') * max_pow) % MOD;
		if (v < 0) v += MOD;
	}

	ll v;
	ll max_pow;
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	string needle, haystack;
	cin >> needle >> haystack;
	if (needle.size() > haystack.size()) {
		cout << "0\n";
		return 0;
	}

	int window_sz = needle.size();
	PolyHash<P> needle_hash_p(window_sz), window_hash_p(window_sz);
	PolyHash<Q> needle_hash_q(window_sz), window_hash_q(window_sz);
	for (int i = 0; i < window_sz; i++) {
		needle_hash_p.push_back(needle[i]);
		needle_hash_q.push_back(needle[i]);
		needle_freq[needle[i] - 'a']++;

		window_hash_p.push_back(haystack[i]);
		window_hash_q.push_back(haystack[i]);
		window_freq[haystack[i] - 'a']++;
	}

	if (memcmp(needle_freq, window_freq, sizeof(needle_freq)) == 0) seen.insert({window_hash_p.v, window_hash_q.v});
	for (int i = 0, j = window_sz; j < haystack.size(); i++, j++) {
		window_hash_p.pop_front(haystack[i]);
		window_hash_q.pop_front(haystack[i]);
		window_freq[haystack[i] - 'a']--;

		window_hash_p.push_back(haystack[j]);
		window_hash_q.push_back(haystack[j]);
		window_freq[haystack[j] - 'a']++;

		if (memcmp(needle_freq, window_freq, sizeof(needle_freq)) == 0) seen.insert({window_hash_p.v, window_hash_q.v});
	}

	cout << seen.size() << '\n';
	return 0;
}