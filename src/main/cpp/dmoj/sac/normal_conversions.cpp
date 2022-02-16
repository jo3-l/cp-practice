#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int q;
	cin >> q;
	while (q--) {
		int b1, b2;
		string n;
		cin >> b1 >> n >> b2;

		// convert to base 10
		int b10 = 0;
		int pow = 1;
		for (auto it = n.rbegin(); it != n.rend(); ++it) {
			b10 += (*it - '0') * pow;
			pow *= b1;
		}

		// convert to b2
		vector<int> out;
		while (b10 >= b2) {
			out.push_back(b10 % b2);
			b10 /= b2;
		}
		out.push_back(b10);
		while (!out.empty() && out.back() == 0) out.pop_back();
		if (out.empty()) cout << '0';
		else copy(out.rbegin(), out.rend(), ostream_iterator<int>(cout));
		cout << '\n';
	}

	return 0;
}