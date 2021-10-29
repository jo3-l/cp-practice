#include <bits/stdc++.h>

using namespace std;

int points[128];
bool is_suit[128];
const string suits[]{"Clubs", "Diamonds", "Hearts", "Spades"};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	is_suit['C'] = is_suit['D'] = is_suit['H'] = is_suit['S'] = true;
	points['A'] = 4;
	points['K'] = 3;
	points['Q'] = 2;
	points['J'] = 1;

	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int total_points = 0;
	cout << "Cards Dealt Points" << '\n';
	cin.ignore(1); // first suit
	for (int i = 0; i < 4; i++) {
		string dealt;
		int cur_points = 0, cnt = 0;
		char c;
		while ((cin >> c) && !is_suit[c]) {
			if (!dealt.empty()) dealt += ' ';
			dealt += c;
			cur_points += points[c];
			cnt++;
		}
		if (cnt < 3) cur_points += 3 - cnt;
		cout << suits[i] << ' ' << dealt << ' ' << cur_points << '\n';
		total_points += cur_points;
	}

	cout << "Total " << total_points << '\n';
	return 0;
}
