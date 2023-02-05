#include <bits/stdc++.h>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	string inst;
	cin >> inst;

	auto cur = inst.begin();
	while (cur != inst.end()) {
		auto plus_minus = find_if(cur, inst.end(), [](char c) { return c == '+' || c == '-'; });
		copy(cur, plus_minus, ostreambuf_iterator(cout));
		cout << ' ' << (*plus_minus == '+' ? "tighten" : "loosen") << ' ';

		auto first_non_digit = find_if_not(next(plus_minus), inst.end(), [](char c) { return '0' <= c && c <= '9'; });
		copy(next(plus_minus), first_non_digit, ostreambuf_iterator(cout));
		cout << '\n';

		cur = first_non_digit;
	}
}
