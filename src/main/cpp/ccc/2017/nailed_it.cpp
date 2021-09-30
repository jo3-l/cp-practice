#include <bits/stdc++.h>

using ll = long long;
using namespace std;

int buckets[2001];
ll fences[4001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int l;
		cin >> l;
		buckets[l]++;
	}

	ll max_len = 0;
	for (int first_len = 1; first_len <= 2000; first_len++) {
		if (buckets[first_len]) {
			for (int second_len = first_len; second_len <= 2000; second_len++) {
				int combined = first_len + second_len;
				ll contrib = min(buckets[first_len], buckets[second_len]);
				if (first_len == second_len) contrib >>= 1;
				fences[combined] += contrib;
				max_len = max(max_len, fences[combined]);
			}
		}
	}

	int heights = 0;
	for (int l = 1; l <= 4000; l++) {
		if (fences[l] == max_len) heights++;
	}

	cout << max_len << ' ' << heights << '\n';
	return 0;
}