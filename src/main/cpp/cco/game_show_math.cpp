#include <bits/stdc++.h>

using namespace std;

char dp_[101][65'000], dummy;
char &dp(int i, int n) {
	if (n < -32'000 || n > 32'000) return dummy;
	return dp_[i][n + 32000];
}

int nums[101];

void solve() {
	memset(dp_, 0, sizeof(dp_));
	int p;
	cin >> p;
	for (int i = 0; i < p; i++) {
		cin >> nums[i];
		if (i > 0) {
			for (int n = -32'000; n <= 32'000; n++) {
				if (dp(i - 1, n - nums[i])) dp(i, n) = '+';			// addition
				if (dp(i - 1, n + nums[i])) dp(i, n) = '-';			// subtraction
				if (n % nums[i] == 0 && dp(i - 1, n / nums[i])) dp(i, n) = '*'; // multiplication
				if (dp(i - 1, n * nums[i])) dp(i, n) = '/';			// division
			}
		} else {
			dp(i, nums[i]) = 1;
		}
	}
	int target;
	cin >> target;
	if (dp(p - 1, target)) {
		vector<string> out{to_string(target), "="};
		for (int i = p - 1, cur = target; i >= 0; i--) {
			out.push_back(to_string(nums[i]));
			if (i > 0) {
				char op = dp(i, cur);
				out.push_back(string{op});
				if (op == '*') cur /= nums[i];
				else if (op == '/') cur *= nums[i];
				else if (op == '+') cur -= nums[i];
				else cur += nums[i];
			}
		}
		copy(out.rbegin(), out.rend(), ostream_iterator<string>(cout));
		cout << '\n';
	} else {
		cout << "NO EXPRESSION" << '\n';
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	while (n--) solve();

	return 0;
}