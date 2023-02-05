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

struct rule {
	string from, to;

	string apply(int pos, string& s) {
		return s.substr(0, pos) + to + s.substr(pos + from.size());
	}
};

struct substitution {
	int rule_idx, pos;
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	array<rule, 3> rules;
	for (auto& r : rules) cin >> r.from >> r.to;

	int max_step;
	string initial, target;
	cin >> max_step >> initial >> target;

	vector<unordered_set<string>> seen(max_step);
	vector<substitution> hist;
	hist.reserve(max_step);
	auto go = y_combinator([&](auto go, int step, string& cur) -> bool {
		if (step == max_step) return cur == target;
		if (seen[step].count(cur)) return false;
		seen[step].insert(cur);

		for (int rule_idx = 0; rule_idx < 3; rule_idx++) {
			auto& r = rules[rule_idx];
			for (size_t pos = cur.find(r.from); pos != string::npos; pos = cur.find(r.from, pos + 1)) {
				string nxt = r.apply(pos, cur);
				hist.push_back({rule_idx, int(pos)});
				if (go(step + 1, nxt)) return true;
				hist.pop_back();
			}
		}
		return false;
	});

	bool ok = go(0, initial);
	assert(ok);

	string cur = initial;
	for (auto& sub : hist) {
		cur = rules[sub.rule_idx].apply(sub.pos, cur);
		cout << sub.rule_idx + 1 << ' ' << sub.pos + 1 << ' ' << cur << '\n';
	}
}