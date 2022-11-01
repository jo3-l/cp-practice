#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, t;
	cin >> n >> t;
	int best_time = numeric_limits<int>::max();
	string best_name;
	for (int i = 0; i < n; i++) {
		string name;
		int dist;
		cin >> name >> dist;
		int time = abs(dist - t);
		if (time < best_time) {
			best_time = time;
			best_name = name;
		}
	}
	cout << best_name << '\n';
}