#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int d;
	string num;
	cin >> d >> num;
	for (int i = 0; i < d - 1; i++) {
		int a = num[i] - '0', b = num[i + 1] - '0';
		if (a < b) {
			swap(num[i], num[i + 1]);
			break;
		}
	}

	copy(num.begin(), num.end(), ostreambuf_iterator(cout));
	cout << '\n';
	return 0;
}