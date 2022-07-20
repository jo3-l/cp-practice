#include <bits/stdc++.h>

using namespace std;

template <typename T>
using min_pq = priority_queue<T, vector<T>, greater<T>>;

class Solution {
public:
	int maximumProduct(vector<int>& nums, int k) {
		static constexpr int MOD = 1e9 + 7;

		min_pq<int> pq(nums.begin(), nums.end());
		while (k--) {
			int x = pq.top();
			pq.pop();
			pq.push(x + 1);
		}
		int64_t ans = 1;
		while (!pq.empty()) {
			ans = (ans * int64_t(pq.top())) % MOD;
		}
		return ans;
	}
};