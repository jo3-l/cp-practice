#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, q;
	cin >> n >> q;
	vector<int> prices(n);
	for (auto& p : prices) cin >> p;
	sort(prices.begin(), prices.end());

	vector<int64_t> psa(n + 1); // psa[i] = prices[0] + ... + prices[i-1]
	partial_sum(prices.begin(), prices.end(), psa.begin() + 1, [](int a, int b) { return int64_t(a) + b; });
	auto query_sum = [&](int lo, int hi) { return psa[hi] - psa[lo]; };
	while (q--) {
		int k, m;
		cin >> k >> m;

		auto calc = [&](int lo, int hi) {
			auto first_purchase = prices.begin() + lo;
			int first_split_price_idx = lower_bound(first_purchase, prices.begin() + hi, k) - first_purchase + lo;

			int64_t lana_paid_full = psa[first_split_price_idx] - psa[lo];
			int64_t over_k = psa[hi] - psa[first_split_price_idx];
			int64_t lana_paid_partial = int64_t(hi - first_split_price_idx) * k;
			int64_t lana = lana_paid_full + lana_paid_partial;
			int64_t fran = over_k - lana_paid_partial;
			return lana - fran;
		};

		int first_over_k = lower_bound(prices.begin(), prices.end(), k) - prices.begin();
		if (first_split_price_idx < n - m) {
			int64_t lana = m * k;
			int64_t fran = query_sum(n - m, n);
		}
	}
}