#include <bits/stdc++.h>

using namespace std;

unordered_map<char, int> sym_val{{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	cin >> s;
	int v = 0;
	for (int i = 0; i < s.length(); i += 2) {
		int sv = sym_val[s[i + 1]];
		int cur_v = (s[i] - '0') * sv;
		if (i < (int)s.length() - 2 && sym_val[s[i + 3]] > sv)
			v -= cur_v;
		else
			v += cur_v;
	}

	cout << v << '\n';
	return 0;
}