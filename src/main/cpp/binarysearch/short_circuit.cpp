#include <bits/stdc++.h>

using namespace std;

bool solve(vector<string> &words) {
	unordered_map<char, pair<vector<int>, vector<int>>> d;
	for (int i = 0; i < words.size(); i++) {
		auto &w = words[i];
		d[w.front()].first.push_back(i);
		d[w.back()].second.push_back(i);
	}
	return all_of(d.begin(), d.end(), [](auto e) {
		auto &[front, back] = e.second;
		if (front.size() > back.size()) return false;
		for (int open : front) {
			if (back.empty()) return false;
			if (back.back() == open) {
				if (back.size() == 1) return false;
				swap(back.back(), back[back.size() - 2]);
			}
			back.pop_back();
		}
		return back.empty();
	});
}