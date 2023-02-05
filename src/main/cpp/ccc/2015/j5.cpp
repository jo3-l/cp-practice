#include <bits/stdc++.h>

using namespace std;

template <class Fun>
class y_combinator_result {
	Fun fun_;

public:
	template <class T>
	explicit y_combinator_result(T&& fun) : fun_(std::forward<T>(fun)) {}
	template <class... Args>
	decltype(auto) operator()(Args&&... args) {
		return fun_(std::ref(*this), std::forward<Args>(args)...);
	}
};

template <class Fun>
decltype(auto) y_combinator(Fun&& fun) {
	return y_combinator_result<std::decay_t<Fun>>(std::forward<Fun>(fun));
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	int n, k;
	cin >> n >> k;

	vector<vector<vector<int>>> memo(n + 1, vector<vector<int>>(k + 1, vector<int>(n + 1, -1)));
	auto f = y_combinator([&](auto f, int pies_remaining, int people_remaining, int min_pies) {
		if (people_remaining == 1) return 1;
		auto& ans = memo[pies_remaining][people_remaining][min_pies];
		if (ans != -1) return ans;

		ans = 0;
		for (int take = min_pies; people_remaining * take <= pies_remaining; take++) {
			ans += f(pies_remaining - take, people_remaining - 1, take);
		}
		return ans;
	});

	cout << f(n, k, 1) << '\n';
}