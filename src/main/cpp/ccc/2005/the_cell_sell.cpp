#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int d, e, w;
	cin >> d >> e >> w;
	int plan_a = max((d - 100) * 25, 0) + 15 * e + 20 * w;
	int plan_b = max((d - 250) * 45, 0) + 35 * e + 25 * w;

	cout << "Plan A costs " << (plan_a / 100) << '.' << setw(2) << setfill('0') << (plan_a % 100) << '\n';
	cout << "Plan B costs " << (plan_b / 100) << '.' << setw(2) << setfill('0') << (plan_b % 100) << '\n';
	if (plan_a < plan_b) cout << "Plan A is cheapest." << '\n';
	else if (plan_a == plan_b) cout << "Plan A and B are the same price." << '\n';
	else cout << "Plan B is cheapest." << '\n';

	return 0;
}