#include <bits/stdc++.h>

using namespace std;

char mother[5][2], father[5][2];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (int g = 0; g < 5; g++) {
		for (int j = 0; j < 2; j++) cin >> mother[g][j];
	}
	for (int g = 0; g < 5; g++) {
		for (int j = 0; j < 2; j++) cin >> father[g][j];
	}

	int x;
	cin >> x;
	while (x--) {
		bool all_possible = true;
		for (int g = 0; g < 5; g++) {
			bool gene_possible = false;
			char v;
			cin >> v;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) gene_possible |= (mother[g][i] <= 'Z' || father[g][j] <= 'Z') == (v <= 'Z');
			}

			all_possible &= gene_possible;
		}

		cout << (all_possible ? "Possible baby." : "Not their baby!") << '\n';
	}

	return 0;
}