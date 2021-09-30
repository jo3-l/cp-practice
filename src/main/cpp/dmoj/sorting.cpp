#include <bits/stdc++.h>

using namespace std;

const int MN = 100;
int nums[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> nums[i];
	sort(begin(nums), begin(nums) + n);
	for (int i = 0; i < n; i++)
		cout << nums[i] << '\n';

	return 0;
}