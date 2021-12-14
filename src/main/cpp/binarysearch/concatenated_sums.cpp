#include <bits/stdc++.h>

using namespace std;

const int pow10[]{10, 100, 1000, 10'000, 100'000, 1'000'000, 10'000'000, 100'000'000, 1'000'000'000};

int get_pad(int n) {
	for (int p : pow10) {
		if (n < p) return p;
	}
	return -1;
}

int solve(vector<int> &nums) {
	int sum = 0, pad = 0;
	for (int n : nums) {
		pad += get_pad(n);
		sum += n;
	}
	int ans = 0;
	for (int n : nums) {
		ans += n * pad + sum;
	}
	return ans;
}