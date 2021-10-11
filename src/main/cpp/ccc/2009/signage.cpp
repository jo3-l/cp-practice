#include <bits/stdc++.h>

using namespace std;

const string words[]{"WELCOME", "TO", "CCC", "GOOD", "LUCK", "TODAY"};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int width;
	cin >> width;
	int i = 0;
	while (i < 6) {
		int lo = i; // first word on line
		int line_width = 0;
		while (i < 6) {
			int min_dots = i - lo; // at least 1 space between all words
			if (line_width + words[i].size() + min_dots > width) break;
			line_width += words[i++].size();
		}

		// words [lo, i) are on the current line
		int words_on_line = i - lo;
		int dots = width - line_width;
		if (words_on_line == 1) {
			cout << words[lo];
			while (dots--)
				cout << '.';
		} else {
			int gaps = words_on_line - 1;
			int dots_per_gap = dots / gaps;
			int extra = dots % gaps;
			cout << words[lo];
			for (int j = lo + 1; j < i; j++) {
				for (int k = 0; k < dots_per_gap + (j - lo <= extra); k++)
					cout << '.';
				cout << words[j];
			}
		}
		cout << '\n';
	}

	return 0;
}