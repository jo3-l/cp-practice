#include <bits/stdc++.h>

using namespace std;

struct cmp {
	bool operator()(pair<int, int> a, pair<int, int> b) const { return a.second < b.second; }
};

class HistoricalMap {
public:
	HistoricalMap() {}

	int get(int key, int timestamp) {
		auto it = mp.find(key);
		if (it == mp.end()) return -1;
		auto &hist = it->second;
		auto hit = hist.upper_bound({-1, timestamp});
		if (hit == hist.begin()) return -1;
		advance(hit, -1);
		return hit->first;
	}

	void set(int key, int val, int timestamp) { mp[key].insert({val, timestamp}); }

private:
	unordered_map<int, multiset<pair<int, int>, cmp>> mp; // k => {v, set_at}[]
};