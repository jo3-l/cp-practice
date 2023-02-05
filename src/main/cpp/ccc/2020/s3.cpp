#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>

using namespace std;
using namespace __gnu_pbds;

struct splitmix64_hash {
	uint64_t operator()(pair<uint64_t, uint64_t> x) const {
		return hash_ull(x.first) * 31 + hash_ull(x.second);
	}

	uint64_t hash_ull(uint64_t x) const {
		// http://xorshift.di.unimi.it/splitmix64.c
		static const uint64_t R = chrono::steady_clock::now().time_since_epoch().count();
		x += 0x9e3779b97f4a7c15;
		x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
		x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
		return x ^ (x >> 31) ^ R;
	}
};

constexpr int64_t P = 31;
constexpr int64_t Q = 47;
constexpr int64_t MOD = 1e9 + 7;

template <int64_t Pow>
struct rolling_poly_hash {
	rolling_poly_hash(int len) : v(), max_pow(1) {
		for (int i = 1; i < len; i++) max_pow = (max_pow * Pow) % MOD;
	}

	void push_back(char c) {
		v = (v * Pow) % MOD;
		v = (v + int64_t(c - 'a')) % MOD;
	}

	void pop_front(char c) {
		v = (v - int64_t(c - 'a') * max_pow) % MOD;
		if (v < 0) v += MOD;
	}

	int64_t v;
	int64_t max_pow;
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	string needle, haystack;
	cin >> needle >> haystack;
	if (needle.size() > haystack.size()) {
		cout << "0\n";
		return 0;
	}

	array<int, 26> needle_freq{}, window_freq{};

	int window_sz = needle.size();
	rolling_poly_hash<P> needle_hash_p(window_sz), window_hash_p(window_sz);
	rolling_poly_hash<Q> needle_hash_q(window_sz), window_hash_q(window_sz);
	for (int i = 0; i < window_sz; i++) {
		needle_hash_p.push_back(needle[i]);
		needle_hash_q.push_back(needle[i]);
		needle_freq[needle[i] - 'a']++;

		window_hash_p.push_back(haystack[i]);
		window_hash_q.push_back(haystack[i]);
		window_freq[haystack[i] - 'a']++;
	}

	gp_hash_table<pair<uint64_t, uint64_t>, null_type, splitmix64_hash> seen;
	if (needle_freq == window_freq) seen.insert({window_hash_p.v, window_hash_q.v});
	for (int i = 0, j = window_sz; j < haystack.size(); i++, j++) {
		window_hash_p.pop_front(haystack[i]);
		window_hash_q.pop_front(haystack[i]);
		window_freq[haystack[i] - 'a']--;

		window_hash_p.push_back(haystack[j]);
		window_hash_q.push_back(haystack[j]);
		window_freq[haystack[j] - 'a']++;

		if (needle_freq == window_freq) seen.insert({window_hash_p.v, window_hash_q.v});
	}

	cout << seen.size() << '\n';
}