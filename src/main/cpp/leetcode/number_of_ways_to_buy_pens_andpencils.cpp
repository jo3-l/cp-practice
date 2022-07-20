#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
	long long waysToBuyPensPencils(int total, int cost1, int cost2) {
		if (cost1 > cost2) swap(cost1, cost2); // ensure cost1 < cost2
		long long ans = 0;
		for (int cnt2 = 0; cnt2 <= total / cost2; cnt2++) ans += (total - cnt2 * cost2) / cost1 + 1;
		return ans;
	}
};