#include <bits/stdc++.h>

using namespace std;

struct pair_hash {
	size_t operator()(const pair<string, string> &p) const { return hash<string>{}(p.first) * 31 + hash<string>{}(p.second); }
};

class UndergroundTunnel {
public:
	void checkIn(int userId, string station, int timestamp) { in_transit[userId] = {station, timestamp}; }

	void checkOut(int userId, string station, int timestamp) {
		auto it = in_transit.find(userId);
		auto &[start_station, start_time] = it->second;
		auto &[time, trips] = stats[{start_station, station}];
		time += timestamp - start_time;
		trips++;
		in_transit.erase(it);
	}

	double averageTime(string start, string end) {
		auto &[time, trips] = stats[{start, end}];
		return (double)time / trips;
	}

private:
	unordered_map<int, pair<string, int>> in_transit;
	unordered_map<pair<string, string>, pair<int, int>, pair_hash> stats;
};