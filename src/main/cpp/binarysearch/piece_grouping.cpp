#include <bits/stdc++.h>

using namespace std;

bool solve(vector<vector<int>> &pieces, vector<int> &target) {
	unordered_map<int, int> idx;
	for (int i = 0; i < pieces.size(); i++) {
		if (!pieces[i].empty()) idx[pieces[i][0]] = i;
	}
	int i = 0;
	while (i < target.size()) {
		auto it = idx.find(target[i]);
		if (it == idx.end()) return false;
		vector<int> &piece = pieces[it->second];
		if (i + piece.size() > target.size()) return false;
		i++;
		for (int j = 1; j < piece.size(); i++, j++) {
			if (piece[j] != target[i]) return false;
		}
	}
	return true;
}