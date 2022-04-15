#include <bits/stdc++.h>

using namespace std;

unordered_map<int, vector<int>> occurrences;
constexpr int MN = 1e5 + 1;
int pfs[MN];

bool check(int a, int b, int x) {
	auto it = occurrences.find(x);
	if (it == occurrences.end()) return false;
	auto& inds = it->second;
	auto inds_it = lower_bound(inds.begin(), inds.end(), a);
	if (inds_it == inds.end()) return false;
	return *inds_it <= b;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, k, q;
	cin >> n >> k >> q;
	for (int i = 1; i <= n; i++) {
		cin >> pfs[i];
		occurrences[pfs[i]].push_back(i);
		pfs[i] += pfs[i - 1];
	}
	while (q--) {
		int a, b, x, y;
		cin >> a >> b >> x >> y;
		auto check = [&](int v) {
			auto it = occurrences.find(v);
			if (it == occurrences.end()) return false;
			auto& inds = it->second;
			auto inds_it = lower_bound(inds.begin(), inds.end(), x);
			if (inds_it == inds.end()) return false;
			return *inds_it <= y;
		};
		if (pfs[y] - pfs[x - 1] <= k || !check(a) || !check(b)) {
			cout << "No" << '\n';
		} else {
			cout << "Yes" << '\n';
		}
	}

	return 0;
}