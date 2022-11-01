#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int n;
	cin >> n;
	unordered_map<string, int> amt;
	int sum = 0;
	int warnings = 0;
	while (n--) {
		string child;
		cin >> child;
		int& cur = amt[child];
		if (cur > sum - cur) warnings++;
		++cur;
		++sum;
	}

	cout << warnings << '\n';
}