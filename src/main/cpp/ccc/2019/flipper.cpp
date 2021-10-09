#include <bits/stdc++.h>

using namespace std;

string combo[2][2] = {
    {"1 2\n3 4", "2 1\n4 3"},
    {"3 4\n1 2", "4 3\n2 1"},
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int h = 0, v = 0;
	string flips;
	cin >> flips;
	for (char c : flips) {
		if (c == 'H')
			h ^= 1;
		else
			v ^= 1;
	}
	cout << combo[h][v] << endl;

	return 0;
}