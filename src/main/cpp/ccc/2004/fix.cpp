#include <bits/stdc++.h>

using namespace std;

bool has_prefix(string &s, string &pref) { return s.size() >= pref.size() && s.compare(0, pref.size(), pref) == 0; }
bool has_suffix(string &s, string &suff) { return s.size() >= suff.size() && s.compare(s.size() - suff.size(), suff.size(), suff) == 0; }

string words[3];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	while (n--) {
		for (int i = 0; i < 3; i++) cin >> words[i];

		for (int i = 0; i < 2; i++) {
			for (int j = i + 1; j < 3; j++) {
				if (has_prefix(words[i], words[j]) || has_prefix(words[j], words[i]) || has_suffix(words[i], words[j]) ||
				    has_suffix(words[j], words[i]))
					goto not_fix_free;
			}
		}

		cout << "Yes" << '\n';
		continue;
	not_fix_free:
		cout << "No" << '\n';
	}

	return 0;
}