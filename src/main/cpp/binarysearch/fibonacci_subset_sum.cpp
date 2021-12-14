#include <bits/stdc++.h>

using namespace std;

int fib[46];

int solve(int n) {
	if (!fib[0]) {
		fib[0] = fib[1] = 1;
		for (int i = 2; i <= 45; i++) fib[i] = fib[i - 1] + fib[i - 2];
	}
	int k = 0;
	while (n > 0) {
		auto it = upper_bound(begin(fib), end(fib), n);
		n -= *--it;
		k++;
	}
	return k;
}