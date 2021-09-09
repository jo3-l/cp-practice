#include <bits/stdc++.h>

using namespace std;

void seed(string &s, int l, int r, int begin = 0) {
	for (int i = l; i < r; i++) {
		s[i] = '0' + begin;
		begin ^= 1;
	}
}

bool next(string &cur) {
	for (int i = cur.size() - 1; i >= 0; i--) {
		if (cur[i] == '2') continue;
		char prev = i > 0 ? cur[i - 1] : 0;
		if (cur[i] + 1 != prev) {
			cur[i]++;
			seed(cur, i + 1, cur.size(), cur[i] == 0 ? 1 : 0);
			return true;
		}
		if (cur[i] == '0') {
			cur[i] = '2';
			seed(cur, i + 1, cur.size());
			return true;
		}
	}
	return false;
}

string solve(int n, int k) {
	string cur(n, '0');
	seed(cur, 0, n);
	if (k == 0) return cur;
	while (k--) {
		bool ok = next(cur);
		if (!ok) return "";
	}
	return cur;
}
