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
		if (c == 'L')
			l_cnt++;
		else if (c == 'M')
			m_cnt++;
		else
			s_cnt++;
	}

	// We'll solve this problem greedily. Let's split the process of
	// arranging the books into two steps. First, we move all the large
	// books into their correct place. To minimize the number of swaps, we
	// will prioritize a swap that gets both elements involved in the swap
	// into their correct sections over one that only gets one into its
	// correct position. That is, we will prefer to make a swap involving a
	// small book in the large section and a large book in the small section
	// over one involving a medium book in the large section and a large
	// book in the small section.
	int l_in_m = 0, l_in_s = 0, s_in_l = 0, s_in_m = 0;
	for (int i = 0; i < shelf.size(); i++) {
		if (i < l_cnt) { // large section
			if (shelf[i] == 'S') s_in_l++;
		} else if (i < l_cnt + m_cnt) { // medium section
			if (shelf[i] == 'L')
				l_in_m++;
			else if (shelf[i] == 'S')
				s_in_m++;
		} else { // small section
			if (shelf[i] == 'L') l_in_s++;
		}
	}
	int l_s_swaps = min(l_in_s, s_in_l);
	cout << l_in_m + l_in_s - l_s_swaps + s_in_m + s_in_l << endl;
	return 0;
}