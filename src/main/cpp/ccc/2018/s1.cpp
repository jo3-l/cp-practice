#include <bits/stdc++.h>

using ull = unsigned long long;

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	vector<int> villages(n);
	for (auto& v : villages) cin >> v;
	sort(villages.begin(), villages.end());

	int64_t min_sz = numeric_limits<int64_t>::max();
	for (int i = 1; i < n - 1; i++) {
		int prev = villages[i - 1], cur = villages[i], next = villages[i + 1];
		min_sz = min(min_sz, (int64_t(cur) - prev) + (int64_t(next) - cur));
	}

	cout << (min_sz >> 1);
	if (min_sz & 1)
		cout << ".5";
	else
		cout << ".0";
	cout << '\n';
}