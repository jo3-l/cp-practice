#include <bits/stdc++.h>

using namespace std;

constexpr int MM = 30'005, MN = 1005;
int diff[MN][MM];

int square(int x) {
	return x * x;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	int m, n, k;
	cin >> m >> n >> k;
	for (int i = 0; i < k; i++) {
		int x, y, r, b;
		cin >> x >> y >> r >> b;
		for (int xv = max(x - r, 1); xv <= min(x + r, n); xv++) {
			// (xv - x)^2 + (yv - y)^2 = r^2
			// (yv - y)^2 = r^2 - (xv - x)^2
			// solving for yv yields up to two y-coordinates where the circle intersects line x = xv
			int p = square(r) - square(xv - x);
			assert(p >= 0); // by xv bounds
			double q = sqrt(double(p));
			int y_max = min<int>(floor(q + y), m); // yv - y = q -> yv = q + y
			int y_min = max<int>(ceil(y - q), 1);  // y - yv = q -> yv = y - q
			diff[xv][y_min] += b;
			diff[xv][y_max + 1] -= b;
		}
	}

	int max_bitrate = 0, cnt = 0;
	for (int x = 1; x <= n; x++) {
		int bitrate = 0;
		for (int y = 1; y <= m; y++) {
			bitrate += diff[x][y];
			if (bitrate > max_bitrate) max_bitrate = bitrate, cnt = 1;
			else if (bitrate == max_bitrate) cnt++;
		}
	}

	cout << max_bitrate << '\n' << cnt << '\n';
	return 0;
}