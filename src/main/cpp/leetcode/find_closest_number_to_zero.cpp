#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
	int findClosestNumber(vector<int>& nums) {
		static constexpr int INF = 0x3f3f3f3f;
		int ans = -INF;
		for (int num : nums) {
			if (abs(num) < abs(ans))
				ans = num;
			else if (abs(num) == abs(ans))
				ans = max(ans, num);
		}
		return ans;
	}
};