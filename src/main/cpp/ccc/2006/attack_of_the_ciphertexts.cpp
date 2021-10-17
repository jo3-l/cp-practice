#include <bits/stdc++.h>

using namespace std;

int cipher[27];
int known = 0;

int remap(char c) {
	if (c == ' ') return 26;
	return c - 'A';
}

char rebuild(int i) {
	if (i == 26) return ' ';
	return i + 'A';
}

int main() {
	memset(cipher, -1, sizeof(cipher));
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string original, result, want;
	getline(cin, original);
	getline(cin, result);
	getline(cin, want);

	int unknown_keys = 1 << 27, unused_values = 1 << 27;
	for (int i = 0; i < result.size(); i++) {
		int k = remap(result[i]), v = remap(original[i]);
		known += cipher[k] == -1;
		cipher[k] = v;
		unknown_keys &= ~(1 << k);
		unused_values &= ~(1 << v);
	}

	// 1 missing
	if (known == 26) {
		int k = __builtin_ctz(unused_values) + 1, v = __builtin_ctz(unknown_keys) + 1;
		cipher[k] = v;
		known++;
	}

	for (int i = 0; i < want.size(); i++) {
		int d = cipher[remap(want[i])];
		cout << (d == -1 ? '.' : rebuild(d));
	}

	cout << '\n';
	return 0;
}