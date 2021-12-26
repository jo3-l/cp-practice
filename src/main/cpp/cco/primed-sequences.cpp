#include <bits/stdc++.h>

using namespace std;

int nums[10'000];
int n;

bool is_prime(int x) {
	if (x <= 2) return x == 2;
	if (!(x & 1)) return false;
	for (int i = 3; i * i <= x; i += 2) {
		if (x % i == 0) return false;
	}
	return true;
}

pair<int, int> check(int len) {
	int sum = accumulate(nums, nums + len, 0);
	if (is_prime(sum)) return {0, len - 1};
	for (int i = 1, j = len; j < n; i++, j++) {
		sum -= nums[i - 1];
		sum += nums[j];
		if (is_prime(sum)) return {i, j};
	}
	return {-1, -1};
}

pair<int, int> solve() {
	cin >> n;
	for (int i = 0; i < n; i++) cin >> nums[i];
	for (int len = 2; len <= n; len++) {
		auto p = check(len);
		if (p.first != -1) return p;
	}
	return {-1, -1};
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int t;
	cin >> t;
	while (t--) {
		int i, j;
		tie(i, j) = solve();
		if (i == -1) {
			cout << "This sequence is anti-primed." << '\n';
		} else {
			cout << "Shortest primed subsequence is length " << (j - i + 1) << ':';
			for (; i <= j; i++) cout << ' ' << nums[i];
			cout << '\n';
		}
	}

	return 0;
}
