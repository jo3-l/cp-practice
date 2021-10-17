#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 101;
int worst_rank[MN];
int cumulative_scores[MN];
pair<int, int> round_scores[MN]; // (id, score)

constexpr int INF = 0x3f3f3f3f;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, k;
	cin >> n >> k;
	while (k--) {
		for (int i = 1; i <= n; i++) {
			int score;
			cin >> score;
			round_scores[i].second = cumulative_scores[i] += score;
			round_scores[i].first = i;
		}

		sort(begin(round_scores) + 1, begin(round_scores) + n + 1,
		     [](pair<int, int> a, pair<int, int> b) { return a.second > b.second; });
		int i = 1;
		while (i <= n) {
			int rank = i, score = round_scores[i].second;
			while (i <= n && round_scores[i].second == score) {
				worst_rank[round_scores[i].first] = max(worst_rank[round_scores[i].first], rank);
				i++;
			}
		}
	}

	vector<int> best;
	for (int i = 1; i <= n; i++) {
		int best_score = best.empty() ? -INF : cumulative_scores[best.front()];
		if (cumulative_scores[i] > best_score) best.clear();
		if (cumulative_scores[i] >= best_score) best.push_back(i);
	}

	sort(best.begin(), best.end());
	for (int i : best)
		cout << "Yodeller " << i << " is the TopYodeller: score " << cumulative_scores[i] << ", worst rank " << worst_rank[i]
		     << '\n';

	return 0;
}