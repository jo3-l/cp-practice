#include <bits/stdc++.h>

using namespace std;

using ll = long long;

int solve(int k) {
	int r = 0;
	for (ll i = 5; i <= k; i *= 5)
		r++;
	return r;
}