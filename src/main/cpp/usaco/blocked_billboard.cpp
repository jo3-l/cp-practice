#include <bits/stdc++.h>

using namespace std;

int intersect_line(int a, int b, int c, int d) { return max(min(b, d) - max(a, c), 0); }

struct Rect {
	int x1, y1, x2, y2;

	int area() { return (x2 - x1) * (y2 - y1); }

	int intersection_with(Rect &other) {
		return intersect_line(x1, x2, other.x1, other.x2) * intersect_line(y1, y2, other.y1, other.y2);
	}
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	freopen("billboard.in", "r", stdin);
	freopen("billboard.out", "w", stdout);

	Rect b1, b2, truck;
	cin >> b1.x1 >> b1.y1 >> b1.x2 >> b1.y2 >> b2.x1 >> b2.y1 >> b2.x2 >> b2.y2 >> truck.x1 >> truck.y1 >> truck.x2 >> truck.y2;
	cout << b1.area() + b2.area() - b1.intersection_with(truck) - b2.intersection_with(truck) << '\n';
	return 0;
}