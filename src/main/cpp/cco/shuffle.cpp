#include <bits/stdc++.h>

using namespace std;

int jmp[31][27];

int into_idx(char c) {
	return c == '_' ? 26 : c - 'A';
}
char from_idx(int idx) {
	return idx == 26 ? '_' : char(idx + 'A');
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	for (int i = 0; i < 27; i++) {
		char c;
		cin >> c;
		jmp[0][i] = into_idx(c);
	}
	for (int k = 1; k < 31; k++) {
		for (int i = 0; i < 27; i++) jmp[k][i] = jmp[k - 1][jmp[k - 1][i]];
	}
	int n;
	cin >> n;
	string msg;
	cin >> msg;
	for (int i = 0; i < msg.size(); i++) {
		int c = into_idx(msg[i]);
		for (int j = 0; j < 31; j++) {
			if (n >> j & 1) c = jmp[j][c];
		}
		cout << from_idx(c);
	}
	cout << '\n';
	return 0;
}
