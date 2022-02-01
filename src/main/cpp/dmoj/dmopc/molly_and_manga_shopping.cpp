#include <bits/stdc++.h>

using namespace std;

constexpr int BLOCK_SZ = 400;

struct Query {
	int idx;
	int l, r;

	bool operator<(Query &other) {
		return make_pair(l / BLOCK_SZ, r) < make_pair(other.l / BLOCK_SZ, other.r);
	}
};

constexpr int MQ = 100'000;
Query queries[MQ];
int ans[MQ];
int manga[100'000];
int freq[100'001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) cin >> manga[i];
	int q;
	cin >> q;
	for (int i = 0; i < q; i++) {
		queries[i].idx = i;
		cin >> queries[i].l >> queries[i].r;
		queries[i].l--;
		queries[i].r--;
	}
	sort(begin(queries), begin(queries) + q);

	int cur_l = 0, cur_r = -1;
	int cur_ans = 0;
	auto add = [&](int i) {
		int new_val = ++freq[manga[i]];
		if (new_val > 1) {
			if (new_val & 1) cur_ans--;
			else cur_ans++;
		}
	};
	auto rm = [&](int i) {
		int new_val = --freq[manga[i]];
		if (new_val > 0) {
			if (new_val & 1) cur_ans--;
			else cur_ans++;
		}
	};
	for (int i = 0; i < q; i++) {
		auto &qry = queries[i];
		while (cur_l > qry.l) {
			cur_l--;
			add(cur_l);
		}
		while (cur_r < qry.r) {
			cur_r++;
			add(cur_r);
		}
		while (cur_l < qry.l) {
			rm(cur_l);
			cur_l++;
		}
		while (cur_r > qry.r) {
			rm(cur_r);
			cur_r--;
		}
		ans[qry.idx] = cur_ans;
	}
	for (int i = 0; i < q; i++) cout << ans[i] << '\n';
	return 0;
}