#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int n, q;
	cin >> n >> q;
	vector<string> typ(n + 1, "rhombus");
	while (q--) {
		string query_typ, kind;
		int i;
		cin >> query_typ >> kind >> i;
		if (query_typ == "set")
			typ[i] = kind;
		else if (query_typ == "get")
			cout << (typ[i] == kind) << '\n';
		else
			assert(false);
	}
	return 0;
}