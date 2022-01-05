#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int l_cnt = 0, m_cnt = 0, s_cnt = 0;
	string shelf;
	cin >> shelf;
	for (char c : shelf) {
		if (c == 'L') l_cnt++;
		else if (c == 'M') m_cnt++;
		else s_cnt++;
	}

	int l_in_m = 0, l_in_s = 0, s_in_l = 0, s_in_m = 0;
	for (int i = 0; i < shelf.size(); i++) {
		if (i < l_cnt) { // large section
			if (shelf[i] == 'S') s_in_l++;
		} else if (i < l_cnt + m_cnt) { // medium section
			if (shelf[i] == 'L') l_in_m++;
			else if (shelf[i] == 'S') s_in_m++;
		} else { // small section
			if (shelf[i] == 'L') l_in_s++;
		}
	}
	int l_s_swaps = min(l_in_s, s_in_l);
	cout << l_in_m + l_in_s - l_s_swaps + s_in_m + s_in_l << endl;
	return 0;
}