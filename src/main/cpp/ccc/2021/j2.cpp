#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;

	string best_bidder;
	int best_bid = -1;
	while (n--) {
		string name;
		int bid;
		cin >> name >> bid;
		if (bid > best_bid) {
			best_bid = bid;
			best_bidder = name;
		}
	}
	cout << best_bidder << '\n';
}
