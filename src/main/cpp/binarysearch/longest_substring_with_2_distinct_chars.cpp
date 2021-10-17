#include <bits/stdc++.h>

using namespace std;

unordered_map<int, int> mp;

int solve(string s) {
	mp.clear();
	int i = 0;
	int ans = 0;
	for (int j = 0; j < s.size(); j++) {
		mp[s[j]]++;
		if (mp.size() <= 2) {
			ans = max(ans, j - i + 1);
		} else if (mp.size() > 2) {
			if (--mp[s[i]] == 0) {
				mp.erase(s[i]);
			}
			i++;
		}
	}
	return ans;
}