#include <bits/stdc++.h>

using namespace std;

class WordDistanceQuerier {
public:
	WordDistanceQuerier(vector<string> &words) {
		for (int i = 0; i < words.size(); i++) {
			pos[words[i]].push_back(i);
		}
	}

	int distance(string a, string b) {
		int min_dist = INT_MAX;
		vector<int> &b_pos = pos[b];
		int j = 0;
		for (int p : pos[a]) {
			while (j < b_pos.size() && b_pos[j] < p) j++;
			if (j > 0) min_dist = min(min_dist, p - b_pos[j - 1]);
			if (j < b_pos.size()) min_dist = min(min_dist, b_pos[j] - p);
		}
		return min_dist;
	}

private:
	unordered_map<string, vector<int>> pos;
};