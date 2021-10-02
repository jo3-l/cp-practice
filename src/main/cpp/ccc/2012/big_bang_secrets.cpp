#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int k;
	string s;
	cin >> k >> s;
	for (int i = 0; i < s.size(); i++) {
		int shift = 3 * (i + 1) + k;
		int v = (s[i] - 'A') - shift;
		while (v < 0)
			v += 26;
		cout << (char)(v + 'A');
	}

	cout << '\n';
	return 0;
}