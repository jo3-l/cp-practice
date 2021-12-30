#include <bits/stdc++.h>

using namespace std;

using ull = unsigned long long;

constexpr int P = 271;
constexpr int MOD = 1e9 + 7;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	string haystack, needle;
	cin >> haystack >> needle;
	if (needle.size() > haystack.size()) {
		cout << 0 << '\n';
		return 0;
	}

	ull needle_hash = 0, window_hash = 0, pow = 1;
	for (int i = 0; i < needle.size(); i++) {
		needle_hash = ((needle_hash * P % MOD) + needle[i] - 'a') % MOD;
		window_hash = ((window_hash * P % MOD) + haystack[i] - 'a') % MOD;
		if (i > 0) pow = (pow * P) % MOD;
	}

	int n = needle_hash == window_hash;
	for (int i = 0, j = needle.size(); j < haystack.size(); i++, j++) {
		window_hash = (window_hash - ((haystack[i] - 'a') * pow) % MOD + MOD) % MOD;
		window_hash = ((window_hash * P % MOD) + haystack[j] - 'a') % MOD;
		n += needle_hash == window_hash;
	}

	cout << n << '\n';
	return 0;
}