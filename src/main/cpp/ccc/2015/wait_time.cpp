#include <bits/stdc++.h>

#define dbg(x) cout << #x << " = " << (x) << '\n'

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	set<int> friends;
	unordered_map<int, int> sent;
	unordered_map<int, int> total_wait_time;
	int time = 0;

	int m;
	cin >> m;
	while (m--) {
		char c;
		int x;
		cin >> c >> x;
		switch (c) {
		case 'W':
			time += x - 1;
			break;
		case 'R':
			friends.insert(x);
			sent[x] = time++;
			break;
		case 'S':
			total_wait_time[x] += time++ - sent[x];
			sent.erase(x);
			break;
		}
	}

	for (int f : friends) {
		cout << f << ' ';
		cout << (sent.find(f) == sent.end() ? total_wait_time[f] : -1) << '\n';
	}

	return 0;
}