#include <bits/stdc++.h>

#define LOCAL

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int c;
	for (cin >> c; c; cin >> c) {
		for (int w = sqrt(c); w; w--) {
			int h = c / w;
			if (w * h == c) {
				cout << "Minimum perimeter is " << (w + h) * 2 << " with dimensions " << w << " x " << h << '\n';
				break;
			}
		}
	}

	return 0;
}