#include <bits/stdc++.h>

using namespace std;

struct Event {
	bool is_join;
	int user_id;
	int time, dur;
};

template <typename T>
using min_pq = priority_queue<T, vector<T>, greater<T>>;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, m;
	cin >> n >> m;
	vector<int> cur_workstation(n);
	vector<Event> events;
	events.reserve(n * 2);
	for (int i = 0; i < n; i++) {
		int starts_at, dur;
		cin >> starts_at >> dur;
		events.push_back({true, i, starts_at, dur});
		events.push_back({false, i, starts_at + dur, 0});
	}

	sort(events.begin(), events.end(),
	     [](Event& a, Event& b) { return a.time < b.time || (a.time == b.time && !a.is_join && b.is_join); });

	int unlocks = 0;
	int id_ctr = 0;
	min_pq<pair<int, int>> unused;
	for (auto evt : events) {
		if (evt.is_join) {
			bool ok = false;
			while (!unused.empty() && !ok) {
				auto [lock_time, id] = unused.top();
				unused.pop();
				if (lock_time >= evt.time) {
					cur_workstation[evt.user_id] = id;
					ok = true;
				}
			}

			if (!ok) {
				cur_workstation[evt.user_id] = id_ctr++;
				unlocks++;
			}
		} else {
			int id = cur_workstation[evt.user_id];
			unused.push({evt.time + m, id});
		}
	}

	cout << n - unlocks << '\n';
	return 0;
}