#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	unordered_map<int, int> readings;
	int n;
	cin >> n;
	while (n--) {
		int r;
		cin >> r;
		readings[r]++;
	}

	vector<int> most_freq;
	int most_freq_cnt = 0;
	vector<int> second_most_freq;
	int second_most_freq_cnt = 0;
	for (auto entry : readings) {
		if (entry.second > most_freq_cnt) {
			second_most_freq = move(most_freq);
			second_most_freq_cnt = most_freq_cnt;
			most_freq.clear();
			most_freq.push_back(entry.first);
			most_freq_cnt = entry.second;
		} else if (entry.second == most_freq_cnt) {
			most_freq.push_back(entry.first);
		} else if (entry.second > second_most_freq_cnt) {
			second_most_freq.clear();
			second_most_freq.push_back(entry.first);
			second_most_freq_cnt = entry.second;
		} else if (entry.second == second_most_freq_cnt) {
			second_most_freq.push_back(entry.first);
		}
	}

	if (most_freq.size() > 1) {
		auto mm = minmax_element(most_freq.begin(), most_freq.end());
		cout << *mm.second - *mm.first << '\n';
	} else {
		auto mm0 = minmax_element(most_freq.begin(), most_freq.end()),
		     mm1 = minmax_element(second_most_freq.begin(), second_most_freq.end());
		cout << max(abs(*mm0.first - *mm1.second), abs(*mm0.second - *mm1.first)) << '\n';
	}
	return 0;
}