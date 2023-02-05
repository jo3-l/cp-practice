#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int k, sum = 0;
	cin >> k;
	stack<int> stk;
	while (k--) {
		int n;
		cin >> n;
		if (n == 0) {
			sum -= stk.top();
			stk.pop();
		} else {
			sum += n;
			stk.push(n);
		}
	}
	cout << sum << '\n';
}