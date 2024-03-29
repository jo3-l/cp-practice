#include <bits/stdc++.h>

using namespace std;

constexpr int adjust(int offset) {
	int h = 12 + offset / 60, m = offset % 60;
	return (h > 12 ? h - 12 : h) * 60 + m;
}

constexpr bool is_arith_seq(int t) {
	int h = t / 60, m = t % 60;
	int h0 = h / 10, h1 = h % 10, m0 = m / 10, m1 = m % 10;
	bool ok = m1 - m0 == m0 - h1;
	return !ok || !h0 ? ok : m0 - h1 == h1 - h0;
}

constexpr int calc(int n) {
	int r = 0;
	for (int i = 0; i <= n; i++) r += is_arith_seq(adjust(i));
	return r;
}

constexpr int CYCLE = 60 * 12; // times repeat after 12h
constexpr int AMT_PER_CYCLE = calc(CYCLE - 1);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int d;
	cin >> d;
	cout << (d / CYCLE) * AMT_PER_CYCLE + calc(d % CYCLE) << '\n';
}