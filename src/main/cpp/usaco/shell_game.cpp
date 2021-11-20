#include <bits/stdc++.h>

using namespace std;

struct Inst {
	int a, b, guess;
};

Inst insts[100];
int n;

int simulate(int loc) {
	int state[]{0, 1, 2, 3};
	int score = 0;
	for (int i = 0; i < n; i++) {
		auto &inst = insts[i];
		swap(state[inst.a], state[inst.b]);
		score += state[inst.guess] == loc;
	}
	return score;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

#ifndef LOCAL
	freopen("shell.in", "r", stdin);
	freopen("shell.out", "w", stdout);
#endif

	cin >> n;
	for (int i = 0; i < n; i++) cin >> insts[i].a >> insts[i].b >> insts[i].guess;
	cout << max({simulate(1), simulate(2), simulate(3)}) << '\n';

	return 0;
}