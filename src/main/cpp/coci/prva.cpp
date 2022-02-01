#include <bits/stdc++.h>

using namespace std;

int r, c;

char crossword[20][20];
bool vis_vertical[20][20];
bool vis_horizontal[20][20];
vector<string> words;

// (i, j) and (i + 1, j) are chars
void go_vertical(int i, int j) {
	string word{crossword[i][j], crossword[i + 1][j]};
	vis_vertical[i][j] = vis_vertical[i + 1][j] = true;
	i += 2;
	for (; i < r && crossword[i][j] != '#'; i++) {
		vis_vertical[i][j] = true;
		word.push_back(crossword[i][j]);
	}
	words.push_back(word);
}

// (i, j) and (i, j + 1) are chars
void go_horizontal(int i, int j) {
	string word{crossword[i][j], crossword[i][j + 1]};
	vis_horizontal[i][j] = vis_horizontal[i][j + 1] = true;
	j += 2;
	for (; j < c && crossword[i][j] != '#'; j++) {
		vis_horizontal[i][j] = true;
		word.push_back(crossword[i][j]);
	}
	words.push_back(word);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	cin >> r >> c;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) cin >> crossword[i][j];
	}

	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (crossword[i][j] == '#') continue;
			if (i < r - 1 && crossword[i + 1][j] != '#' && !vis_vertical[i][j]) go_vertical(i, j);
			if (j < c - 1 && crossword[i][j + 1] != '#' && !vis_horizontal[i][j]) go_horizontal(i, j);
		}
	}

	cout << *min_element(words.begin(), words.end()) << '\n';
	return 0;
}