#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n;
	cin >> n;
	vector<int> heights(n + 1);
	for (auto& h : heights) cin >> h;
	vector<int> widths(n);
	for (auto& w : widths) cin >> w;

	int64_t rect_area = 0;
	for (int i = 0; i < n; i++) {
		int h1 = heights[i], h2 = heights[i + 1];
		rect_area += (h1 + h2) * widths[i];
	}
	cout << (rect_area >> 1);
	if (rect_area & 1) cout << ".5";
	cout << '\n';
}
