#include <bits/stdc++.h>

using namespace std;

string solve(vector<int> &nums) {
	sort(nums.begin(), nums.end(), [](int a, int b) {
		string as = to_string(a), bs = to_string(b);
		return stoi(as + bs) > stoi(bs + as);
	});
	string res;
	for (int &v : nums)
		res += to_string(v);
	return res;
}
