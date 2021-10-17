#include <bits/stdc++.h>

using namespace std;

struct Inst {
	char dir;
	string to;
};

constexpr int MN = 5;
Inst insts[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int i;
	for (i = 0;; i++) {
		cin >> insts[i].dir >> insts[i].to;
		if (insts[i].to == "SCHOOL") break;
	}

	for (int j = i; j > 0; j--) {
		cout << "Turn " << (insts[j].dir == 'R' ? "LEFT" : "RIGHT") << " onto " << insts[j - 1].to << " street." << '\n';
	}
	cout << "Turn " << (insts[0].dir == 'R' ? "LEFT" : "RIGHT") << " into your HOME." << '\n';

	return 0;
}