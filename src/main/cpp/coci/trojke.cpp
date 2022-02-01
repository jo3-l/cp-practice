#include <bits/stdc++.h>

using namespace std;

constexpr double VERTICAL = 1e9;
constexpr double EPS = 1e-9;

double slope(pair<int, int> a, pair<int, int> b) {
	if (a.first == b.first) return VERTICAL;
	return (double)(b.second - a.second) / (b.first - a.first);
}

double eq(double a, double b) {
	return abs(a - b) < EPS;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	vector<pair<int, int>> letters;
	for (int y = 0; y < n; y++) {
		for (int x = 0; x < n; x++) {
			char c;
			cin >> c;
			if (c != '.') letters.push_back({x, y});
		}
	}

	int cnt = 0;
	for (int i = 0; i < letters.size() - 2; i++) {
		for (int j = i + 1; j < letters.size() - 1; j++) {
			for (int k = j + 1; k < letters.size(); k++) {
				double m1 = slope(letters[i], letters[j]), m2 = slope(letters[j], letters[k]),
				       m3 = slope(letters[i], letters[k]);
				if (eq(m1, m2) && eq(m2, m3) && eq(m1, m3)) cnt++;
			}
		}
	}

	cout << cnt << '\n';
	return 0;
}