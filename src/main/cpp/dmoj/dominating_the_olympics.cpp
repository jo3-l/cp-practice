#include <bits/stdc++.h>

using namespace std;

constexpr int IMPOSSIBLE = 0x3f3f3f3f;
constexpr int PENDING = -1;

struct Evt {
	int dur;
	vector<int> prereqs;
};

constexpr int MN = 100'005;
Evt evts[MN];
int done_at[MN];

int attempt(int evt_id) {
	if (done_at[evt_id] != PENDING) return done_at[evt_id];
	auto& evt = evts[evt_id];
	int max_time = 0;
	done_at[evt_id] = IMPOSSIBLE;
	for (int prereq : evt.prereqs) max_time = max(max_time, attempt(prereq));
	return done_at[evt_id] = max_time + evt.dur;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> evts[i].dur;
		int cnt;
		cin >> cnt;
		evts[i].prereqs.resize(cnt);
		for (auto& x : evts[i].prereqs) cin >> x;
	}

	memset(done_at, -1, sizeof(done_at));
	int max_time = 0;
	for (int i = 1; i <= n; i++) {
		int time = attempt(i);
		if (time < IMPOSSIBLE) max_time = max(max_time, time);
	}
	cout << max_time << '\n';
	return 0;
}