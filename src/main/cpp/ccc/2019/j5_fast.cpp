#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>

using namespace std;
using namespace __gnu_pbds;

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

struct ab_str {
	uint64_t val;
	int len;

	ab_str(uint64_t val_, int len_) : val(val_), len(len_) {}
	ab_str() = default;

	ab_str replace(int pos, int del_len, ab_str repl) {
		uint64_t left = val & ((uint64_t(1) << pos) - 1);
		uint64_t right = val >> pos;
		right >>= del_len;
		right <<= repl.len;
		right |= repl.val;
		return {left | (right << pos), len - del_len + repl.len};
	}

	int a_count() {
		return len - b_count();
	}
	int b_count() {
		return __builtin_popcountll(val);
	}

	bool operator==(ab_str const& other) const {
		return val == other.val && len == other.len;
	}
};

ostream& operator<<(ostream& os, ab_str& s) {
	for (int i = 0; i < s.len; i++) os << ((s.val >> i & 1) ? 'B' : 'A');
	return os;
}
istream& operator>>(istream& is, ab_str& s) {
	string raw;
	is >> raw;
	s.len = raw.size();
	s.val = 0;
	for (int i = 0; i < raw.size(); i++) s.val |= uint64_t(raw[i] == 'B') << i;
	return is;
}

struct ab_str_hash {
	uint64_t operator()(ab_str const& x) const {
		return x.val * 31 + x.len;
	}
};

struct rule {
	ab_str from, to;

	rule() = default;

	int a_delta() {
		return to.a_count() - from.a_count();
	}
	int b_delta() {
		return to.b_count() - from.b_count();
	}
	int len_delta() {
		return to.len - from.len;
	}

	void reverse() {
		swap(from, to);
	}
};

struct substitution {
	int rule_idx, pos;
};

constexpr int MAX_INTERMEDIATE_LEN = 64;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin.exceptions(cin.failbit);

	array<rule, 3> rules;
	for (auto& r : rules) cin >> r.from >> r.to;

	int max_step;
	ab_str initial, target;
	cin >> max_step >> initial >> target;

	// start with the longer string; work backward if needed
	bool run_in_reverse = initial.len < target.len;
	if (run_in_reverse) {
		swap(initial, target);
		for (auto& r : rules) r.reverse();
	}

	// precompute possible combinations of a, b at given step
	vector<array<array<bool, MAX_INTERMEDIATE_LEN + 1>, MAX_INTERMEDIATE_LEN + 1>> possible_ab_counts(max_step + 1);
	for (int remaining_steps = 0; remaining_steps <= max_step; remaining_steps++) {
		int step = max_step - remaining_steps;
		for (int apply0 = 0; apply0 <= remaining_steps; apply0++) {
			for (int apply1 = 0; apply0 + apply1 <= remaining_steps; apply1++) {
				int apply2 = remaining_steps - apply0 - apply1;
				int total_a_delta = rules[0].a_delta() * apply0 + rules[1].a_delta() * apply1 + rules[2].a_delta() * apply2;
				int total_b_delta = rules[0].b_delta() * apply0 + rules[1].b_delta() * apply1 + rules[2].b_delta() * apply2;

				int a_count = target.a_count() - total_a_delta;
				int b_count = target.b_count() - total_b_delta;
				if (0 <= a_count && a_count <= MAX_INTERMEDIATE_LEN && 0 <= b_count && b_count <= MAX_INTERMEDIATE_LEN) {
					possible_ab_counts[step][a_count][b_count] = true;
				}
			}
		}
	}

	vector<gp_hash_table<ab_str, null_type, ab_str_hash>> seen(max_step);
	vector<substitution> hist;
	hist.reserve(max_step);

	auto go = y_combinator([&](auto go, int step, ab_str cur) {
		if (step == max_step) return cur == target;
		if (seen[step].find(cur) != seen[step].end()) return false;
		seen[step].insert(cur);

		for (int rule_idx = 0; rule_idx < 3; rule_idx++) {
			auto& r = rules[rule_idx];
			int new_a = cur.a_count() + r.a_delta(), new_b = cur.b_count() + r.b_delta();
			int new_len = cur.len - r.from.len + r.to.len;
			if (new_a < 0 || new_b < 0 || new_len < 0 || new_len > MAX_INTERMEDIATE_LEN ||
			    !possible_ab_counts[step + 1][new_a][new_b]) {
				continue;
			}

			uint64_t mask = (1 << r.from.len) - 1;
			uint64_t remaining = cur.val;
			vector<int> indices;
			for (int i = 0; i <= cur.len - r.from.len; i++, remaining >>= 1) {
				if ((remaining & mask) == r.from.val) indices.push_back(i);
			}

			// prefer applying rules near the middle
			int mid = cur.len / 2;
			sort(indices.begin(), indices.end(), [&](int a, int b) { return abs(a - mid) < abs(b - mid); });
			for (int i : indices) {
				hist.push_back({rule_idx, i});
				bool ok = go(step + 1, cur.replace(i, r.from.len, r.to));
				if (ok) return true;
				hist.pop_back();
			}
		}
		return false;
	});

	bool ok = go(0, initial);
	assert(ok);

	if (run_in_reverse) {
		swap(initial, target);
		for (rule& r : rules) r.reverse();
		reverse(hist.begin(), hist.end());
	}

	ab_str cur = initial;
	for (auto& sub : hist) {
		auto& r = rules[sub.rule_idx];
		cur = cur.replace(sub.pos, r.from.len, r.to);
		cout << sub.rule_idx + 1 << ' ' << sub.pos + 1 << ' ' << cur << '\n';
	}
}
