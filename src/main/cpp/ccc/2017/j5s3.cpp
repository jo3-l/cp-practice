#include <bits/stdc++.h>

using ll = long long;
using namespace std;

constexpr int MAX_WOOD_LENGTH = 2000;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;

	vector<int> num_wood(MAX_WOOD_LENGTH + 1); // num_wood[L] is number of pieces of woods with length L
	for (int i = 0; i < n; i++) {
		int len;
		cin >> len;
		num_wood[len]++;
	}

	vector<int> num_fences(MAX_WOOD_LENGTH * 2 + 1); // num_fences[L] is max len of fence with height L
	int max_len = 0;
	for (int h1 = 1; h1 <= MAX_WOOD_LENGTH; h1++) {
		if (!num_wood[h1]) continue;
		for (int h2 = h1; h2 <= MAX_WOOD_LENGTH; h2++) {
			int n = min(num_wood[h1], num_wood[h2]);
			if (h1 == h2) n /= 2;
			num_fences[h1 + h2] += n;
			max_len = max(max_len, num_fences[h1 + h2]);
		}
	}

	cout << max_len << ' ' << count(num_fences.begin(), num_fences.end(), max_len) << '\n';
}