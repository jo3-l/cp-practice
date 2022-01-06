#pragma GCC target("popcnt")
#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>

using namespace std;
using namespace __gnu_pbds;
using ull = unsigned long long;

template <typename V> struct AbStr {
	AbStr(V val_, int len_) : val(val_), len(len_) {}
	AbStr() = default;

	template <typename U> AbStr<V> replace(int pos, int del_len, AbStr<U> repl) const {
		V left = val & (((V)1 << pos) - 1);
		V right = val >> pos;
		right >>= del_len;
		right <<= repl.len;
		right |= repl.val;
		return {left | (right << pos), len - del_len + repl.len};
	}

	int a_count() const { return len - b_count(); }
	int b_count() const { return __builtin_popcountll(val); }

	void swap(AbStr &other) {
		::swap(other.val, val);
		::swap(other.len, len);
	}

	bool operator==(AbStr const &other) const { return val == other.val && len == other.len; }

	V val;
	int len;
};

template <typename U> ostream &operator<<(ostream &os, AbStr<U> const &s) {
	for (int i = 0; i < s.len; i++) os << ((s.val & ((U)1 << i)) ? 'B' : 'A');
	return os;
}
template <typename U> istream &operator>>(istream &is, AbStr<U> &s) {
	string in;
	is >> in;
	s.len = in.size();
	for (int i = 0; i < in.size(); i++) s.val |= (U)(in[i] == 'B') << i;
	return is;
}

struct Rule {
	int a_delta() { return to.a_count() - from.a_count(); }
	int b_delta() { return to.b_count() - from.b_count(); }
	int len_delta() { return to.len - from.len; }

	void reverse() { from.swap(to); }
	void swap(Rule &other) {
		from.swap(other.from);
		to.swap(other.to);
		::swap(other.num, num);
	}

	AbStr<int> from, to;
	int num;
};
Rule rules[3];

struct Substitution {
	int rule_num, pos;
};
Substitution hist[20];

int max_step;
AbStr<ull> initial_str, final_str;

bool is_ok_ab_count[20][70][70];
void calc_ok_ab_counts() {
	for (int remaining_steps = 0; remaining_steps <= max_step; remaining_steps++) {
		int step = max_step - remaining_steps;
		for (int r1 = 0; r1 <= remaining_steps; r1++) {
			for (int r2 = 0; r1 + r2 <= remaining_steps; r2++) {
				int r3 = remaining_steps - r1 - r2;
				int cum_a_delta = rules[0].a_delta() * r1 + rules[1].a_delta() * r2 + rules[2].a_delta() * r3;
				int cum_b_delta = rules[0].b_delta() * r1 + rules[1].b_delta() * r2 + rules[2].b_delta() * r3;
				int expected_a = final_str.a_count() - cum_a_delta;
				int expected_b = final_str.b_count() - cum_b_delta;
				if (0 <= expected_a && expected_a < 70 && 0 <= expected_b && expected_b < 70) {
					is_ok_ab_count[step][expected_a][expected_b] = true;
				}
			}
		}
	}
}

struct Hash {
	ull operator()(AbStr<ull> const &x) const { return x.val * 31 + x.len; }
};
gp_hash_table<AbStr<ull>, null_type, Hash> seen[20];

bool search(int step, AbStr<ull> const &cur) {
	if (step == max_step) return cur == final_str;
	if (seen[step].find(cur) != seen[step].end()) return false;
	seen[step].insert(cur);

	for (Rule &rule : rules) {
		int a_after_app = cur.a_count() + rule.a_delta(), b_after_app = cur.b_count() + rule.b_delta();
		int len_after_app = cur.len - rule.from.len + rule.to.len;
		if (a_after_app < 0 || b_after_app < 0 || len_after_app < 0 || len_after_app > 64 ||
		    !is_ok_ab_count[step + 1][a_after_app][b_after_app]) {
			continue;
		}

		int mask = (1 << rule.from.len) - 1;
		ull rest = cur.val;
		vector<int> indices;
		for (int i = 0; i <= cur.len - rule.from.len; i++, rest >>= 1) {
			if ((rest & mask) == rule.from.val) indices.push_back(i);
		}

		// prefer applying rules near the middle as opposed to the end
		int mid = cur.len / 2;
		sort(indices.begin(), indices.end(), [&](int a, int b) { return abs(a - mid) < abs(b - mid); });
		for (int i : indices) {
			hist[step].rule_num = rule.num;
			hist[step].pos = i;
			bool solved = search(step + 1, cur.replace(i, rule.from.len, rule.to));
			if (solved) return true;
		}
	}
	return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	for (int i = 0; i < 3; i++) {
		rules[i].num = i + 1;
		cin >> rules[i].from >> rules[i].to;
	}
	cin >> max_step >> initial_str >> final_str;

	// start with the longer string (i.e., work backward if needed)
	bool reversed = initial_str.len < final_str.len;
	if (reversed) {
		initial_str.swap(final_str);
		for (Rule &rule : rules) rule.reverse();
	}

	calc_ok_ab_counts();
	bool has_solution = search(0, initial_str);
	assert(has_solution);

	if (reversed) {
		initial_str.swap(final_str);
		for (Rule &rule : rules) rule.reverse();
		reverse(begin(hist), begin(hist) + max_step);
	}

	AbStr<ull> cur = initial_str;
	for (int i = 0; i < max_step; i++) {
		Rule &rule = *find_if(begin(rules), end(rules), [&](Rule &r) { return r.num == hist[i].rule_num; });
		cur = cur.replace(hist[i].pos, rule.from.len, rule.to);
		cout << rule.num << ' ' << hist[i].pos + 1 << ' ' << cur << '\n';
	}

	return 0;
}