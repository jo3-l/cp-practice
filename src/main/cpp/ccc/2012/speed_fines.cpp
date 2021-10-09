#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int l, s;
	cin >> l >> s;
	if (s <= l)
		cout << "Congratulations, you are within the speed limit!";
	else if (s <= l + 20)
		cout << "You are speeding and your fine is $100.";
	else if (s <= l + 30)
		cout << "You are speeding and your fine is $270.";
	else
		cout << "You are speeding and your fine is $500.";

	return 0;
}