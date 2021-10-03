#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int s, m, l;
	cin >> s >> m >> l;
	int score = s + 2 * m + 3 * l;
	cout << (score >= 10 ? "happy" : "sad") << endl;

	return 0;
}