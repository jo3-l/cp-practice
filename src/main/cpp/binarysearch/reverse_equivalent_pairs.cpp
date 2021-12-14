#include <bits/stdc++.h>

using namespace std;

constexpr int MOD = 1e9 + 7;

int solve(vector<int> &nums) {
	transform(nums.begin(), nums.end(), nums.begin(), [](int n) {
		int reversed = 0;
		for (int i = n; i > 0; i /= 10) reversed = (reversed * 10) + i % 10;
		return n - reversed;
	});
	unordered_map<int, int> cnt;
	return accumulate(nums.begin(), nums.end(), 0, [&](int acc, int x) { return (acc + (++cnt[x] % MOD)) % MOD; });
}