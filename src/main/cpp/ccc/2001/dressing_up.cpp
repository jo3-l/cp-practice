#include <bits/stdc++.h>

using namespace std;

int h;

void print(int k) {
	for (int i = 0; i < k; i++) cout << '*';
	for (int i = 0; i < 2 * (h - k); i++) cout << ' ';
	for (int i = 0; i < k; i++) cout << '*';
	cout << '\n';
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> h;
	for (int k = 1; k <= h; k += 2) print(k);
	for (int k = h - 2; k >= 1; k -= 2) print(k);
	return 0;
}
