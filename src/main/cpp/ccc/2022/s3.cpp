#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int64_t notes, max_pitch, want;
	cin >> notes >> max_pitch >> want;
	want -= notes;
	if (want < 0) {
		cout << -1 << '\n';
		return 0;
	}

	vector<int> piece(notes);
	piece[0] = 1;
	int good_suffix_len = 1;
	for (int i = 1; i < notes; i++) {
		if (want == 0) {
			piece[i] = piece[i - 1];
		} else if (i < max_pitch && i <= want) {
			good_suffix_len++;
			piece[i] = piece[i - 1] + 1;
			want -= i;
		} else {
			good_suffix_len = min<int64_t>(want + 1, good_suffix_len);
			piece[i] = piece[i - good_suffix_len];
			want -= good_suffix_len - 1;
		}
	}

	if (want != 0) {
		cout << -1 << '\n';
	} else {
		cout << piece[0];
		for (int i = 1; i < notes; i++) cout << ' ' << piece[i];
		cout << '\n';
	}
}
