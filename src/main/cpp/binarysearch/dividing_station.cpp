#include <bits/stdc++.h>

using namespace std;

int solve(vector<int>& nums) {
    sort(nums.begin(), nums.end());
    int msz = 0;
    for (int i = 0; i < nums.size(); i++) {
        int v = nums[i];
        int sz = 1;
        for (int j = i + 1; j < nums.size(); j++) {
            if (nums[j] % v == 0) {
                sz++;
                v = nums[j];
            }
        }
        msz = max(msz, sz);
    }
    return msz;
}