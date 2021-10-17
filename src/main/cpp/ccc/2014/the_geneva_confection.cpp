#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 100'000;
int cars[MN];
int branch[MN];
int branch_size = 0;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int t;
	cin >> t;
	for (; t > 0; t--, branch_size = 0) {
		int n;
		cin >> n;
		for (int i = 0; i < n; i++) cin >> cars[i];

		int want = 1;
		auto push_branch = [&]() {
			while (branch_size > 0 && branch[branch_size - 1] == want) {
				branch_size--;
				want++;
			}
		};
		for (int i = n - 1; i >= 0; i--) {
			int car = cars[i];
			push_branch();
			if (car == want) want++;
			else branch[branch_size++] = car;
		}
		push_branch();
		cout << (want == n + 1 ? 'Y' : 'N') << '\n';
	}

	return 0;
}