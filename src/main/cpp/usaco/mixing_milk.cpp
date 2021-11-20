#include <bits/stdc++.h>

using namespace std;

struct Bucket {
	int amt, cap;
};
Bucket buckets[3];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

#ifndef LOCAL
	freopen("mixmilk.in", "r", stdin);
	freopen("mixmilk.out", "w", stdout);
#endif

	for (int i = 0; i < 3; i++) cin >> buckets[i].cap >> buckets[i].amt;
	for (int i = 0, from = 0; i < 100; i++, from = (from + 1) % 3) {
		int to = (from + 1) % 3;
		int p = min(buckets[to].cap - buckets[to].amt, buckets[from].amt);
		buckets[to].amt += p;
		buckets[from].amt -= p;
	}
	for (int i = 0; i < 3; i++) cout << buckets[i].amt << '\n';

	return 0;
}