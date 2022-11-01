#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	vector<int> qualities(n * 2);
	for (auto& q : qualities) cin >> q;
	sort(qualities.begin(), qualities.end());

	int64_t x = 0;
	for (int i = 0; i < n * 2; i += 2) x += qualities[i + 1] - qualities[i];
	cout << x << '\n';
}