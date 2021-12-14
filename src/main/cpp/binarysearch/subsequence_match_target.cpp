#include <bits/stdc++.h>

using namespace std;

int solve(vector<string> &words, string s) {
	unordered_map<int, vector<int>> lpos;
	for (int i = 0; i < s.size(); i++) lpos[s[i]].push_back(i);
	int n = 0;
	for (string &w : words) {
		int i = -1, j;
		for (j = 0; j < w.size(); j++) {
			auto it = lpos.find(w[j]);
			if (it == lpos.end()) break;
			vector<int> &found = it->second;
			auto pit = upper_bound(found.begin(), found.end(), i);
			if (pit == found.end()) break;
			i = *pit;
		}
		n += j >= w.size();
	}
	return n;
}