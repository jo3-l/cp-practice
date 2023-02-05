#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	vector<pair<string, string>> partners(n);
	for (auto& p : partners) cin >> p.first;
	for (auto& p : partners) cin >> p.second;

	bool any_self_partner = any_of(partners.begin(), partners.end(), [](pair<string, string> p) { return p.first == p.second; });
	bool any_inconsistent = any_of(partners.begin(), partners.end(), [&](pair<string, string> p) {
		return find(partners.begin(), partners.end(), pair{p.second, p.first}) == partners.end();
	});
	if (any_self_partner || any_inconsistent)
		cout << "bad\n";
	else
		cout << "good\n";
}