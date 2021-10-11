#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>

using ld = long double;
using namespace std;
using namespace __gnu_pbds;

template <typename T>
using ordered_vector =
    tree<T, null_type, less_equal<T>, rb_tree_tag,
	 tree_order_statistics_node_update>; // less_equal<> to (sort of) support duplicates; really scuffed

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	unordered_map<int, int> cnt; // take care of duplicates
	ordered_vector<int> scores;
	int n;
	cin >> n;
	ld avg = 0;
	for (int i = 1; i <= n; i++) {
		int k;
		cin >> k;
		scores.insert(k);
		cnt[k]++;
		int rank = i - scores.order_of_key(k) - cnt[k] + 1;
		// update rolling average
		avg += (ld)(rank - avg) / i;
	}

	// truncate to 2 places
	cout << setprecision(2) << fixed << (avg * 100) / 100 << '\n';
	return 0;
}