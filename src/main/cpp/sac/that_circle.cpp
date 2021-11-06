#include <bits/stdc++.h>

using namespace std;

using ld = long double;
constexpr ld PI = 3.14159265354;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int l, h, w, d;
	cin >> l >> h >> w >> d;
	ld r = (ld)d / 2;
	ld vol = l * h * w;
	cout << fixed << vol - (PI * r * r * h) << '\n';
	return 0;
}
