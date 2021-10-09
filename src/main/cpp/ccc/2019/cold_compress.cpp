#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	while (n--) {
		string s;
		cin >> s;
		int i = 0;
		while (i < s.size()) {
			if (i > 0) cout << ' ';
			int start = i;
			char c = s[i++];
			while (i < s.size() && s[i] == c)
				i++;
			cout << i - start << ' ' << c;
		}
		cout << '\n';
	}

	return 0;
}