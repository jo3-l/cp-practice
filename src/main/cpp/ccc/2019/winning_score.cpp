#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int a, b, c, d, e, f;
	cin >> a >> b >> c >> d >> e >> f;
	int apples_score = (a * 3) + (b * 2) + c;
	int bananas_score = (d * 3) + (e * 2) + f;
	if (apples_score > bananas_score)
		cout << 'A';
	else if (apples_score == bananas_score)
		cout << 'T';
	else
		cout << 'B';
	cout << endl;

	return 0;
}