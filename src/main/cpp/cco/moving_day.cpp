#include <bits/stdc++.h>

using namespace std;

int nxt[101];
string name_of[101];
int mark[101];
vector<int> locs;
vector<string> order;

constexpr int VISITED_MARK = 1, TMP_MARK = 2;

void go(int loc) {
	if (mark[loc] == VISITED_MARK) return;
	mark[loc] = TMP_MARK;
	int to = nxt[loc];
	if (mark[to] == TMP_MARK) {
		cout << "Impossible" << '\n';
		exit(0);
	}
	go(to);
	mark[loc] = VISITED_MARK;
	order.push_back(name_of[loc]);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		string name;
		int from, to;
		cin >> name >> from >> to;
		name_of[from] = name;
		nxt[from] = to;
		locs.push_back(from);
	}

	mark[0] = VISITED_MARK;
	for (int loc : locs) go(loc);
	for (string &s : order) cout << s << '\n';
	return 0;
}