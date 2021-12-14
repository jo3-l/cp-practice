#include <bits/stdc++.h>

using namespace std;

int t[100'000][19];

int query(int l, int r) {
    int k = 31 - __builtin_clz(r - l + 1);
    return max(t[l][k], t[r - (1 << k) + 1][k]);
}

vector<int> solve(vector<int>& prices) {
    if (prices.empty()) return prices;
    for (int i = 0; i < prices.size(); i++) t[i][0] = prices[i];
    int mk = 32 - __builtin_clz(prices.size() - 1);
    for (int k = 1; k <= mk; k++) {
        for (int i = 0; i + (1 << k) <= prices.size(); i++) {
            t[i][k] = max(t[i][k - 1], t[i + (1 << (k - 1))][k - 1]);
        }
    }
    for (int i = 0; i < prices.size(); i++) {
        int lo = i, hi = prices.size() - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (query(i, mid) > prices[i]) hi = mid;
            else lo = mid + 1;
        }
        if (query(i, lo) > prices[i]) prices[i] = lo - i;
        else prices[i] = 0;
    }
    return prices;
}