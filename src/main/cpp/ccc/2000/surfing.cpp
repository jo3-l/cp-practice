#include <bits/stdc++.h>

using namespace std;

unordered_map<string, vector<string>> adj;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int p;
	cin >> p;
	for (int i = 0; i < p; i++) {
		string cur;
		cin >> cur >> ws;
		string buf;
		for (getline(cin, buf); buf != "</HTML>"; getline(cin, buf)) {
			int last_end = 0;
			size_t pos;
			while ((pos = buf.find("<A HREF=\"", last_end)) != string::npos) {
				string link;
				for (last_end = pos + 9; buf[last_end] != '"'; last_end++) link += buf[last_end];
				adj[cur].push_back(link);
				cout << "Link from " << cur << " to " << link << '\n';
				last_end += 2;
			}
		}
	}

	string a;
	for (cin >> a; a != "The"; cin >> a) {
		string b;
		cin >> b;
		unordered_set<string> seen;
		queue<string> q;
		q.push(a);
		seen.insert(a);

		bool can_surf = false;
		while (!q.empty()) {
			string c = q.front();
			q.pop();
			for (string t : adj[c]) {
				if (t == b) {
					can_surf = true;
					goto done;
				}
				if (!seen.count(t)) {
					q.push(t);
					seen.insert(t);
				}
			}
		}
	done:
		cout << (can_surf ? "Can surf" : "Can't surf") << " from " << a << " to " << b << '.' << '\n';
	}

	return 0;
}