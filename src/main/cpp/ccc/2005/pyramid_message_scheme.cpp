#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 100;
string chain[MN];

unordered_map<string, vector<string>> network;

int get_max_depth(string &node) {
	auto it = network.find(node);
	if (it == network.end()) return 0;
	int ans = 1;
	for (string &child : it->second) ans = max(ans, get_max_depth(child) + 1);
	return ans;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int l;
	cin >> l;
	for (; l--; network.clear()) {
		int n;
		cin >> n;
		if (n == 1) {
			cout << 0 << '\n';
			continue;
		}

		for (int i = 0; i < n; i++) cin >> chain[i];
		string &root = chain[n - 1];
		network[root].push_back(chain[0]);
		for (int i = 1; i < n; i++) {
			auto it = network.find(chain[i]);
			if (it == network.end() || find(it->second.begin(), it->second.end(), chain[i - 1]) == it->second.end()) {
				network[chain[i - 1]].push_back(chain[i]);
			}
		}

		cout << (n - (get_max_depth(root) * 2)) * 10 << '\n';
	}

	return 0;
}