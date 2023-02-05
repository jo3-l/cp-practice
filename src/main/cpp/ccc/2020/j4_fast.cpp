#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>

using namespace std;
using namespace __gnu_pbds;

constexpr int64_t MOD = (1LL << 55) + 3;
constexpr int64_t P = 31;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	string t, s;
	cin >> t >> s;
	gp_hash_table<int64_t, null_type> t_hashes;
	if (t.size() < s.size()) {
		cout << "no\n";
		return 0;
	}

	int64_t t_hash = 0, s_hash = 0;
	int64_t p_pow = 1;
	for (int i = 0; i < s.size(); i++) {
		t_hash = (((t_hash * P) % MOD) + (t[i] - 'A')) % MOD;
		s_hash = (((s_hash * P) % MOD) + (s[i] - 'A')) % MOD;
		if (i > 0) p_pow = (p_pow * P) % MOD;
	}
	t_hashes.insert(t_hash);
	for (int lo = 0, hi = s.size(); hi < t.size(); lo++, hi++) {
		t_hash = (t_hash - ((p_pow * (t[lo] - 'A')) % MOD)) % MOD;
		if (t_hash < 0) t_hash += MOD;
		t_hash = ((t_hash * P) % MOD + (t[hi] - 'A')) % MOD;
		t_hashes.insert(t_hash);
	}
	for (int i = 0; i < s.size(); i++) {
		s_hash = (s_hash - ((p_pow * (s[i] - 'A')) % MOD)) % MOD;
		if (s_hash < 0) s_hash += MOD;
		s_hash = (((s_hash * P) % MOD) + (s[i] - 'A')) % MOD;
		if (t_hashes.find(s_hash) != t_hashes.end()) {
			cout << "yes\n";
			return 0;
		}
	}
	cout << "no\n";
}