#include <bits/stdc++.h>

using namespace std;

using ull = unsigned long long;

struct UllPairHash {
	ull operator()(pair<ull, ull> const &p) const { return hash<ull>{}(p.first) ^ hash<ull>{}(p.second) >> 2; }
};

const int Q = 101;
const int P = 257;

// Rabin-Karp, for fun.
bool solve(string &s, string &t) {
	if (t.size() < s.size()) return false;
	unordered_set<pair<ull, ull>, UllPairHash> target_hashes;
	ull hash_q = 0, hash_p = 0;
	ull target_hash_q = 0, target_hash_p = 0;
	ull max_q = 1, max_p = 1;
	for (int i = 0; i < s.size(); i++) {
		target_hash_p = target_hash_p * P + t[i] - 'A';
		target_hash_q = target_hash_q * Q + t[i] - 'A';
		hash_q = hash_q * Q + s[i] - 'A';
		hash_p = hash_p * P + s[i] - 'A';
		if (i > 0) {
			max_p *= P;
			max_q *= Q;
		}
	}
	target_hashes.insert({target_hash_p, target_hash_q});
	if (target_hash_p == hash_p && target_hash_q == hash_q) return true;
	for (int i = 1, j = s.size(); j < t.size(); i++, j++) {
		target_hash_p = (target_hash_p - (t[i - 1] - 'A') * max_p) * P + t[j] - 'A';
		target_hash_q = (target_hash_q - (t[i - 1] - 'A') * max_q) * Q + t[j] - 'A';
		if (target_hash_p == hash_p && target_hash_q == hash_q) return true;
		target_hashes.insert({target_hash_p, target_hash_q});
	}

	for (int i = 0; i < s.size(); i++) {
		// remove ith character, then add it to the back
		hash_p = (hash_p - (s[i] - 'A') * max_p) * P + s[i] - 'A';
		hash_q = (hash_q - (s[i] - 'A') * max_q) * Q + s[i] - 'A';
		if (target_hashes.count({hash_p, hash_q})) return true;
	}

	return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string t;
	string s;
	cin >> t >> s;
	cout << (solve(s, t) ? "yes" : "no") << endl;
	return 0;
}