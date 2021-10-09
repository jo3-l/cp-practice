#include <bits/stdc++.h>

using namespace std;

constexpr int MN = 10'001;
int heights[MN];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i <= n; i++)
		cin >> heights[i];

	double total_area = 0;
	for (int i = 0; i < n; i++) {
		int width;
		cin >> width;
		total_area += ((heights[i] + heights[i + 1]) / (double)2) * width;
	}
	cout << fixed << total_area << endl;

	return 0;
}