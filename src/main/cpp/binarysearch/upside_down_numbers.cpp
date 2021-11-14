#include <bits/stdc++.h>

using namespace std;

template <class Fun> class y_combinator_result {
	Fun fun_;

public:
	template <class T> explicit y_combinator_result(T &&fun) : fun_(std::forward<T>(fun)) {}
	template <class... Args> decltype(auto) operator()(Args &&...args) { return fun_(std::ref(*this), std::forward<Args>(args)...); }
};

template <class Fun> decltype(auto) y_combinator(Fun &&fun) { return y_combinator_result<std::decay_t<Fun>>(std::forward<Fun>(fun)); }

char get_flipped(char c) {
	switch (c) {
		case '0':
			return '0';
		case '1':
			return '1';
		case '6':
			return '9';
		case '8':
			return '8';
		default:
			return '6';
	}
}

char flippable[]{'0', '1', '6', '8', '9'};
char same[]{'0', '1', '8'};

vector<string> solve(int n) {
	if (n == 0) return {};
	vector<string> ans;
	int half = (n + 1) >> 1;
	string cur(half, 0);
	auto rec = y_combinator([&](auto rec, int i) -> void {
		if (i == half) {
			string copy = cur;
			copy.resize(n);
			for (int j = 0; j < half; j++) copy[n - j - 1] = get_flipped(copy[j]);
			ans.push_back(copy);
		} else if ((n & 1) && i == half - 1) {
			for (int j = 0; j < 3; j++) {
				cur[i] = same[j];
				rec(i + 1);
			}
		} else {
			for (int j = i == 0; j < 5; j++) {
				cur[i] = flippable[j];
				rec(i + 1);
			}
		}
	});
	rec(0);
	return ans;
}