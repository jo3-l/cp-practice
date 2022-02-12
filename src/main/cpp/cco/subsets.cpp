#include <bits/stdc++.h>

using namespace std;

int known;
int subsets[26];
int elements[26];
int set_equalities[26];
bool resolved[26];

int find_cycle(int i, int seen) {
	for (int j = 0; j < 26; j++) {
		if (subsets[i] >> j & 1) {
			if (seen >> j & 1) return seen;
			int cycle = find_cycle(j, seen | (1 << j));
			if (cycle) return cycle;
		}
	}
	return 0;
}

void resolve(int i) {
	for (int j = 0; j < 26; j++) {
		if (subsets[i] >> j & 1) {
			if (!resolved[j]) {
				resolved[j] = true;
				resolve(j);
			}
			elements[i] |= elements[j];
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	while (n--) {
		char par;
		cin >> par >> ws;
		known |= 1 << (par - 'A');
		cin.ignore(numeric_limits<streamsize>::max(), ' ');
		char child;
		cin >> child;
		if (islower(child)) {
			elements[par - 'A'] |= 1 << (child - 'a');
		} else {
			subsets[par - 'A'] |= 1 << (child - 'A');
			known |= 1 << (child - 'A');
		}
	}

	// force subsets to be a DAG
	for (int i = 0; i < 26; i++) {
		if (!(known >> i & 1)) continue;
		int cycle = find_cycle(i, 1 << i);
		if (cycle) {
			set_equalities[i] = cycle;
			for (int j = 0; j < 26; j++) {
				if (cycle >> j & 1) subsets[i] ^= 1 << j;
			}
		}
	}

	for (int i = 0; i < 26; i++) {
		if (known >> i & 1) {
			resolved[i] = true;
			resolve(i);
		}
	}

	// fix equalities
	for (int i = 0; i < 26; i++) {
		if (known >> i & 1) {
			for (int j = 0; j < 26; j++) {
				if (set_equalities[i] >> j & 1) elements[i] |= elements[j];
			}
			cout << char('A' + i) << " = {";
			for (int j = 0, seen = 0; j < 26; j++) {
				if (elements[i] >> j & 1) {
					if (seen++ > 0) cout << ',';
					cout << char('a' + j);
				}
			}
			cout << '}' << '\n';
		}
	}

	return 0;
}