#include <bits/stdc++.h>

using namespace std;

bool is_palin(string &s, int i, int j) {
	while (i < j) {
		if (s[i++] != s[j--]) return false;
	}
	return true;
}

bool solve(string a, string b) {
	if (a.empty()) return true;
	for (int i = 0, j = a.size() - 1; i < j; i++, j--) {
		if (a[i] != b[j]) {
			// a[:i] and b[j+1:] form a palindrome
			// check the mid
			return is_palin(a, i, j) || is_palin(b, i, j);
		}
	}
	return true;
}