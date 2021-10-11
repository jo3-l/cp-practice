#include <bits/stdc++.h>

using namespace std;

int states[2][1 << 8], len[2];
bool seen[1 << 8];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int r, l;
	cin >> r >> l;
	for (int i = 0; i < r; i++) {
		int state = 0;
		for (int j = 0; j < l; j++) {
			int b;
			cin >> b;
			state |= b << j;
		}

		if (i == 0) {
			states[0][0] = state;
			len[0]++;
		} else {
			states[i & 1][0] = state;
			len[i & 1] = 1;
			seen[state] = true;
			for (int j = 0; j < len[(i & 1) ^ 1]; j++) {
				int next_state = states[(i & 1) ^ 1][j] ^ state;
				if (!seen[next_state]) {
					states[i & 1][len[i & 1]++] = next_state;
					seen[next_state] = true;
				}
			}

			memset(seen, false, sizeof(seen));
		}
	}

	cout << len[(r & 1) ^ 1] << '\n';
	return 0;
}