#include <bits/stdc++.h>

using namespace std;
using ld = long double;
using ll = long long;

constexpr int INF = 0x3f3f3f3f;

int p;

ld apply(int m, int cs, int e) {
	ld csp = 1;
	for (int i = 0; i < p; i++) csp *= cs;
	return 4 * sqrt((ld)m) + 3 * csp - 4 * e;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n >> p;
	ld min_score = LDBL_MAX, max_score = LDBL_MIN;
	string min_name, max_name;
	while (n--) {
		string name;
		int m, cs, e;
		cin >> name >> m >> cs >> e;
		ld r = apply(m, cs, e);
		if (r < min_score) {
			min_score = r;
			min_name = name;
		}
		if (r > max_score) {
			max_score = r;
			max_name = name;
		}
	}

	cout << max_name << ' ' << (ll)floor(max_score) << '\n';
	cout << min_name << ' ' << (ll)floor(min_score) << '\n';
	return 0;
}