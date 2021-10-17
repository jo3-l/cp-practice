#include <bits/stdc++.h>

using namespace std;

const int burgers[]{461, 431, 420, 0};
const int sides[]{100, 57, 70, 0};
const int drinks[]{130, 160, 118, 0};
const int desserts[]{167, 266, 75, 0};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int a, b, c, d;
	cin >> a >> b >> c >> d;
	int calories = burgers[a - 1] + sides[b - 1] + drinks[c - 1] + desserts[d - 1];
	cout << "Your total Calorie count is " << calories << '.' << '\n';

	return 0;
}