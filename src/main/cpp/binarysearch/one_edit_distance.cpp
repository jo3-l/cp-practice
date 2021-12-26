#include <bits/stdc++.h>

using namespace std;

bool solve(string a, string b) {
	if (a.size() > b.size()) swap(a, b);
	if (a.size() == b.size()) {
		int diff = 0;
		for (int i = 0; i < a.size() && diff <= 1; i++) diff += a[i] != b[i];
		return diff <= 1;
	}
	if (b.size() - a.size() > 1) return false;
	for (int i = 0; i < a.size(); i++) {
		if (a[i] != b[i]) {
			for (; i < a.size(); i++) {
				if (a[i] != b[i + 1]) return false;
			}
			break;
		}
	}
	return true;
}