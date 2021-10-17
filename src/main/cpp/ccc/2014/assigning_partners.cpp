#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 30;
string names[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	if (n & 1) {
		cout << "bad" << '\n';
		return 0;
	}

	unordered_map<string, string> partners;
	for (int i = 0; i < n; i++) cin >> names[i];

	for (int i = 0; i < n; i++) {
		string partner;
		cin >> partner;
		if (partner == names[i]) {
			cout << "bad" << '\n';
			return 0;
		}

		auto it = partners.find(partner);
		if (it == partners.end()) {
			partners[names[i]] = partner;
			auto itp = partners.find(names[i]);
			if (itp != partners.end() && itp->second != partner) {
				cout << "bad" << '\n';
				return 0;
			}
			partners[partner] = names[i];
		}
	}

	cout << "good" << '\n';
	return 0;
}