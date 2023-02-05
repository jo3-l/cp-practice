#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	string s;
	int q;
	cin >> s >> q;
	while (q--) {
		string t;
		int k;
		cin >> t >> k;
		int offset = 0;
		for (int n = 1; n <= k; n++) {
			size_t p = s.find(t, offset);
			if (p == string::npos) {
				offset = -1;
				break;
			}
			offset = p + 1;
		}
		cout << offset << '\n';
	}

	return 0;
}