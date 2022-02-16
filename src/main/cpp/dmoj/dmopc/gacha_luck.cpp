#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, k;
	cin >> n >> k;
	string record;
	cin >> record;

	int i = 0;
	vector<int> sizes;
	while (i < n) {
		int mark = i;
		if (record[i++] == '1') continue;
		while (i < n && record[i] == '0') i++;
		sizes.push_back(i - mark);
	}
	if (sizes.size() <= k) {
		cout << reduce(sizes.begin(), sizes.end()) << '\n';
	} else {
		nth_element(sizes.begin(), sizes.begin() + k - 1, sizes.end(), greater<int>{});
		cout << reduce(sizes.begin(), sizes.begin() + k) << '\n';
	}
	return 0;
}