#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	string votes;
	cin >> votes;
	int a = count(votes.begin(), votes.end(), 'A'), b = n - a;
	if (a > b)
		cout << "A\n";
	else if (b > a)
		cout << "B\n";
	else
		cout << "Tie\n";
}