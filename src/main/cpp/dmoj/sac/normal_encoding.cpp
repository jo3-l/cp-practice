#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 1e4 + 5;
string dp[MN];

bool better(string &a, string &b) {
	if (a.size() < b.size()) return true;
	return a.size() == b.size() && lexicographical_compare(a.begin(), a.end(), b.begin(), b.end());
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, m;
	cin >> n >> m;
	string msg;
	msg.reserve(m);
	cin >> msg;

	unordered_map<string, char> lookup;
	while (n--) {
		char c;
		string bin;
		cin >> c >> bin;
		auto it = lookup.find(bin);
		if (it != lookup.end()) it->second = min(it->second, c);
		else lookup[bin] = c;
	}

	dp[0] = "$";
	for (int i = 1; i <= m; i++) {
		string *best = nullptr;
		char best_c;
		string cur;
		for (int j = i; j > max(0, i - 10); j--) {
			cur.insert(cur.begin(), msg[j - 1]);
			if (dp[j - 1].empty()) continue;
			auto it = lookup.find(cur);
			if (it == lookup.end()) continue;
			if (!best || better(dp[j - 1], *best)) {
				best = &dp[j - 1];
				best_c = it->second;
			}
		}
		if (best) {
			dp[i] = *best;
			dp[i].push_back(best_c);
		}
	}

	copy(dp[m].begin() + 1, dp[m].end(), ostreambuf_iterator(cout));
	cout << '\n';
	return 0;
}