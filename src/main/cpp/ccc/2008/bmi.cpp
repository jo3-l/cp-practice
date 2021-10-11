#include <bits/stdc++.h>

using ld = long double;
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int w;
	ld h;
	cin >> w >> h;
	ld bmi = w / (h * h);
	if (bmi < 18.5) cout << "Underweight" << '\n';
	else if (bmi <= 25) cout << "Normal weight" << '\n';
	else cout << "Overweight" << '\n';

	return 0;
}