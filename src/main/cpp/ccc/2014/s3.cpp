#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int t;
	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		vector<int> ingredients(n);
		for (auto& i : ingredients) cin >> i;
		reverse(ingredients.begin(), ingredients.end());

		int cur = 1;
		stack<int> branch;
		auto flush_branch = [&] {
			while (!branch.empty() && branch.top() == cur) {
				branch.pop();
				cur++;
			}
		};
		for (int i : ingredients) {
			flush_branch();
			if (i == cur) {
				cur++;
				flush_branch();
			} else {
				branch.push(i);
			}
		}
		cout << (branch.empty() ? 'Y' : 'N') << '\n';
	}
}