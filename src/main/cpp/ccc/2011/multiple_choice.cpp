#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 10'000;
char response[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> response[i];

	int cnt = 0;
	for (int i = 0; i < n; i++) {
		char ans;
		cin >> ans;
		cnt += ans == response[i];
	}

	cout << cnt << '\n';
	return 0;
}