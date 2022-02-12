#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, len;
	cin >> n >> len;
	int time = 0;
	int last_pos = 0;
	while (n--) {
		int pos, red_dur, green_dur;
		cin >> pos >> red_dur >> green_dur;
		time += pos - last_pos; // time to get to this spot

		int k = time % (red_dur + green_dur);
		time += max(red_dur - k, 0);

		last_pos = pos;
	}

	cout << time + (len - last_pos) << '\n';
	return 0;
}