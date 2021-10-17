#include <bits/stdc++.h>

using namespace std;

struct Box {
	int len, width, height;

	int volume() { return len * width * height; }
};

constexpr int MN = 1000;
Box boxes[MN];

constexpr int INF = 0x3f3f3f3f;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) cin >> boxes[i].len >> boxes[i].width >> boxes[i].height;

	int m;
	cin >> m;
	while (m--) {
		int ans = INF;
		int len, width, height;
		cin >> len >> width >> height;
		for (Box &b : boxes) {
			auto ok = [&](int x, int y, int z) { return b.len >= x && b.width >= y && b.height >= z; };
			if (ok(len, width, height) || ok(len, height, width) || ok(width, len, height) || ok(width, height, len) ||
			    ok(height, width, len) || ok(height, len, width)) {
				ans = min(ans, b.volume());
			}
		}

		if (ans == INF) cout << "Item does not fit." << '\n';
		else cout << ans << '\n';
	}

	return 0;
}