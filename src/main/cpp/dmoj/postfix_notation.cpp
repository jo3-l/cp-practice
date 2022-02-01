#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	stack<double> q;
	string line;
	getline(cin, line);
	stringstream ss(line);
	string v;
	while (ss >> v) {
		if (v.size() > 1 || isdigit(v[0])) {
			q.push(stoi(v));
		} else {
			assert(q.size() >= 2);
			double x2 = q.top();
			q.pop();
			double x1 = q.top();
			q.pop();

			if (v[0] == '*') q.push(x1 * x2);
			else if (v[0] == '/') q.push(x1 / x2);
			else if (v[0] == '+') q.push(x1 + x2);
			else if (v[0] == '-') q.push(x1 - x2);
			else if (v[0] == '%') q.push((int)x1 % (int)x2);
			else q.push(pow(x1, x2));
		}
	}

	cout << fixed << setprecision(5) << q.top() << '\n';
	return 0;
}