#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
	int largestInteger(int num) {
		string s = to_string(num);
		for (int i = 0; i < s.size(); i++) {
			for (int j = i + 1; j < s.size(); j++) {
				int cur = s[i] - '0', other = s[j] - '0';
				if ((cur & 1) == (other & 1) && cur < other) swap(s[i], s[j]);
			}
		}
		return stoi(s);
	}
};