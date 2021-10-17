#include <bits/stdc++.h>

using namespace std;

const int MN = 1e5;

class StockSpan {
public:
	StockSpan() : data(MN << 1), day(0) {}

	int next(int price) {
		int cur_day = day++;
		int i = MN + cur_day;
		data[i] = price;
		for (; i > 1; i >>= 1) data[i >> 1] = max(data[i], data[i ^ 1]);

		// let's run a binary search on [0, cur_day] to find the first
		// day where max(prices[i..cur_day]) is <= price.
		int lo = 0, hi = cur_day, res = cur_day;
		while (lo < hi) {
			int mid = (lo + hi) >> 1;
			if (query(mid, cur_day + 1) <= price) hi = res = mid;
			else lo = mid + 1;
		}
		return cur_day - res + 1;
	}

private:
	vector<int> data;
	int day;

	// max on [l, r)
	int query(int l, int r) {
		int res = INT_MIN;
		for (l += MN, r += MN; l < r; l >>= 1, r >>= 1) {
			if (l & 1) res = max(res, data[l++]);
			if (r & 1) res = max(res, data[--r]);
		}
		return res;
	}
};