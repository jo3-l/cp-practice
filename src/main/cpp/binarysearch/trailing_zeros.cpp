#include <bits/stdc++.h>

using namespace std;

using i64 = long long int;

int solve(int k) {
	int r = 0;
	for (i64 i = 5; i <= k; i *= 5)
		r++;
	return r;
}