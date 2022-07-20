#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
	int minimumRounds(vector<int>& tasks) {
		sort(tasks.begin(), tasks.end());
		int i = 0;
		int ans = 0;
		while (i < tasks.size()) {
			int mark = i;
			int typ = tasks[i++];
			while (i < tasks.size() && tasks[i] == typ) i++;
			int t = completeSameLvl(i - mark);
			if (t == -1) return -1;
			ans += t;
		}
		return ans;
	}

	int completeSameLvl(int cnt) {
		if (cnt < 2) return -1;
		switch (cnt % 3) {
			case 0:
				return cnt / 3;
			case 1:
				return 2 + (cnt - 4) / 3;
			case 2:
				return 1 + (cnt - 2) / 3;
		}
		return -1;
	}
};