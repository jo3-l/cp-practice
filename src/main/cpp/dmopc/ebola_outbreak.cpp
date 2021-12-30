#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 100'001;

vector<int> classes[MN], students[MN];
bitset<MN> class_inf, student_inf;

void infect(int n) {
	for (int c : classes[n]) {
		if (class_inf[c]) continue;
		class_inf[c] = true;
		for (int s : students[c]) {
			if (!student_inf[s]) {
				student_inf[s] = true;
				infect(s);
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, m;
	cin >> n >> m;
	for (int c = 1; c <= m; c++) {
		int k;
		cin >> k;
		students[c].resize(k);
		for (int &s : students[c]) {
			cin >> s;
			classes[s].push_back(c);
		}
	}

	student_inf[1] = true;
	infect(1);
	string buf;
	int inf = 0;
	for (int s = 1; s <= n; s++) {
		if (student_inf[s]) {
			if (s > 1) buf += ' ';
			buf += to_string(s);
			inf++;
		}
	}

	cout << inf << '\n' << buf << '\n';
	return 0;
}