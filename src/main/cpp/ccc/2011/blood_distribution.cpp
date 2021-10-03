#include <bits/stdc++.h>

#define dbg(x) cout << #x << " = " << (x) << '\n'

using namespace std;

// Greedy algorithm. Works on the original CEMC test data, but fails on DMOJ additional data :/
int calc(int people, int &supply) {
	int treated = min(supply, people);
	supply -= treated;
	return treated;
}
template <typename... A> int calc(int people, int &supply, A &...can_accept) {
	int treated = min(supply, people);
	supply -= treated;
	return treated + calc(people - treated, can_accept...);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int o_neg, o_pos, a_neg, a_pos, b_neg, b_pos, ab_neg, ab_pos;
	cin >> o_neg >> o_pos >> a_neg >> a_pos >> b_neg >> b_pos >> ab_neg >> ab_pos;

	int o_neg_p, o_pos_p, a_neg_p, a_pos_p, b_neg_p, b_pos_p, ab_neg_p, ab_pos_p;
	cin >> o_neg_p >> o_pos_p >> a_neg_p >> a_pos_p >> b_neg_p >> b_pos_p >> ab_neg_p >> ab_pos_p;

	cout << calc(o_neg_p, o_neg) + calc(o_pos_p, o_pos, o_neg) + calc(a_neg_p, a_neg, o_neg) +
		    calc(a_pos_p, a_pos, o_pos, a_neg, o_neg) + calc(b_neg_p, b_neg, o_neg) +
		    calc(b_pos_p, b_pos, o_pos, b_neg, o_neg) + calc(ab_neg_p, ab_neg, o_neg, a_neg, b_neg) +
		    calc(ab_pos_p, ab_pos, o_pos, a_pos, b_pos, ab_neg, o_neg, a_neg, b_neg);
	return 0;
}