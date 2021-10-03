#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int l;
	cin >> l;
	while (l--) {
		int n;
		char c;
		cin >> n >> c;
		while (n--)
			cout << c;
		cout << '\n';
	}

	return 0;
}