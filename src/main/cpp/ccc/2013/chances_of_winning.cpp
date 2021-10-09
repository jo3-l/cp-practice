#include <bits/stdc++.h>

using namespace std;

constexpr int TEAMS = 4;
int score[TEAMS];
int cur_score[TEAMS];

list<pair<int, int>> games{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3}};

int pow3[]{1, 3, 9, 27, 81, 243, 729};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int t, g;
	cin >> t >> g;
	t--; // adjust to 0-based
	while (g--) {
		int a, b, a_s, b_s;
		cin >> a >> b >> a_s >> b_s;
		// adjust to 0-based
		a--;
		b--;
		score[a] += a_s > b_s ? 3 : a_s == b_s;
		score[b] += b_s > a_s ? 3 : b_s == a_s;
		games.remove({a, b});
	}

	int ans = 0;
	// base 3
	for (int i = 0; i < pow3[games.size()]; i++) {
		memcpy(cur_score, score, sizeof(cur_score));
		int outcomes = i;
		for (auto game : games) {
			int a, b;
			tie(a, b) = game;
			int outcome = outcomes % 3;
			if (outcome == 0) {
				cur_score[a] += 3;
			} else if (outcome == 1) {
				cur_score[a]++;
				cur_score[b]++;
			} else {
				cur_score[b] += 3;
			}
			outcomes /= 3;
		}

		int not_t = 0;
		for (int i = 0; i < TEAMS; i++) {
			if (i != t) not_t = max(not_t, cur_score[i]);
		}
		ans += not_t < cur_score[t];
	}

	cout << ans << '\n';
	return 0;
}