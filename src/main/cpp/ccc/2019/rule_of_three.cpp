// Full marks on the original CCC test data but TLEs with additional data from DMOJ. General idea: brute force using a
// breadth-first search with several optimizations:
// 	- Meet-in-the-middle trick for high step counts
// 	- Duplicate strings at the same step are discarded
// 	- Reversed singly-linked list is used to store history so appending a value to the end of
// the list without modifying the original can be done in O(1)
// 	- Binary strings are represented as unsigned 128-bit integers for faster search (O(n)) +
// replace (O(1))
// 	- Maximum possible length of the string is computed and strings going over that length
// are pruned
// 	- Strings that cannot possibly turn into the target string after any seqeuence of rules are
// discarded
#include <bits/stdc++.h>

using namespace std;

using ull = unsigned long long;
using uint128 = unsigned __int128;

struct HistoryNode {
	int rule, pos; // zero-based
	HistoryNode *prev;
};

template <typename T, bool WithLenBit> T encode(string &s) {
	T bits = 0, k = 1;
	for (char c : s) {
		if (c == 'B') bits |= k;
		k <<= 1;
	}
	if (WithLenBit) bits |= k;
	return bits;
}

struct Rule {
	string from, to;
	int from_enc, to_enc;
	int fwd_a_delta, fwd_b_delta;
	int rev_a_delta, rev_b_delta;

	void init() {
		from_enc = encode<int, false>(from);
		to_enc = encode<int, false>(to);
		fwd_a_delta = (int)count(to.begin(), to.end(), 'A') - count(from.begin(), from.end(), 'A');
		fwd_b_delta = (int)count(to.begin(), to.end(), 'B') - count(from.begin(), from.end(), 'B');
		rev_a_delta = (int)count(from.begin(), from.end(), 'A') - count(to.begin(), to.end(), 'A');
		rev_b_delta = (int)count(from.begin(), from.end(), 'B') - count(to.begin(), to.end(), 'B');
	}

	uint128 apply(uint128 s, int pos) {
		uint128 left = s & (((uint128)1 << pos) - 1);
		uint128 right = s >> pos;
		right >>= from.size();
		right <<= to.size();
		right |= to_enc;
		return left | (right << pos);
	}

	void flip() {
		swap(from, to);
		swap(from_enc, to_enc);
		swap(fwd_a_delta, rev_a_delta);
		swap(fwd_b_delta, rev_b_delta);
	}
};

Rule rules[3];
int target_step;
string initial_str, final_str;

int max_len;

int get_len(uint128 s) {
	for (int i = max_len; i >= 1; i--) {
		if (s & ((uint128)1 << i)) return i;
	}
	return 0;
};

int count_b(uint128 s) { return __builtin_popcountll(s >> 64) + __builtin_popcountll(s) - 1; }

void upd_max_len() {
	int max_diff = -0x3f3f3f;
	for (Rule r : rules) {
		max_diff = max(max_diff, (int)r.to.size() - (int)r.from.size());
	}
	max_len = initial_str.size() + max_diff * target_step;
}

string decode(uint128 s) {
	int len = get_len(s);
	string decoded(len, 'A');
	for (int i = 0; i < len; i++)
		if (s & ((uint128)1 << i)) decoded[i] = 'B';
	return decoded;
}

struct UInt128Hash {
	ull operator()(uint128 i) const { return hash<ull>{}(i) ^ hash<ull>{}(i >> 64); }
};

bool ok[70][70];
void upd_ok(int steps) {
	int final_a = count(final_str.begin(), final_str.end(), 'A'),
	    final_b = count(final_str.begin(), final_str.end(), 'B');
	memset(ok, false, sizeof(ok));
	for (int r0 = 0; r0 <= steps; r0++) {
		for (int r1 = 0; r0 + r1 <= steps; r1++) {
			int r2 = steps - r0 - r1;
			int a =
			    final_a + rules[0].rev_a_delta * r0 + rules[1].rev_a_delta * r1 + rules[2].rev_a_delta * r2;
			int b =
			    final_b + rules[0].rev_b_delta * r0 + rules[1].rev_b_delta * r1 + rules[2].rev_b_delta * r2;
			if (0 <= a && a < max_len && 0 <= b && a < max_len) {
				ok[a][b] = true;
			}
		}
	}
}

deque<pair<uint128, HistoryNode *>> q;
unordered_set<uint128, UInt128Hash> seen;

template <typename F> void search(int max_steps, F f) {
	uint128 initial_enc = encode<uint128, true>(initial_str);
	q.push_back({initial_enc, nullptr});
	seen.insert(initial_enc);
	int cur_step = 1;
	while (!q.empty()) {
		upd_ok(target_step - cur_step);
		int sz = q.size();
		while (sz--) {
			pair<uint128, HistoryNode *> state = q.front();
			int len = get_len(state.first);
			q.pop_front();
			for (int i = 0; i < 3; i++) {
				Rule &r = rules[i];
				int max_start_pos = len - r.from.size();
				if (max_start_pos < 0) continue;

				int mask = (1 << r.from.size()) - 1;
				int rest = state.first;
				for (int j = 0; j <= max_start_pos; j++, rest >>= 1) {
					if ((rest & mask) != r.from_enc) continue;

					int new_len = len - r.from.size() + r.to.size();
					if (new_len > max_len) continue;

					uint128 applied = r.apply(state.first, j);
					if (seen.count(applied)) continue;

					int b = count_b(applied), a = new_len - b;
					if (!ok[a][b]) continue;

					seen.insert(applied);
					HistoryNode *node = new HistoryNode{i, j, state.second};
					pair<uint128, HistoryNode *> next_state = {applied, node};
					if (cur_step == max_steps) {
						bool all_done = f(next_state);
						if (all_done) goto done;
					} else {
						q.push_back(next_state);
					}
				}
			}
		}

		cur_step++;
		seen.clear();
	}

done:
	q.clear();
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin >> rules[0].from >> rules[0].to >> rules[1].from >> rules[1].to >> rules[2].from >> rules[2].to >>
	    target_step >> initial_str >> final_str;
	for (Rule &r : rules)
		r.init();
	upd_max_len();

	uint128 final_enc = encode<uint128, true>(final_str);
	if (target_step <= 8) {
		search(target_step, [&](pair<uint128, HistoryNode *> state) {
			if (state.first == final_enc) {
				// found last one
				vector<HistoryNode *> nodes;
				while (state.second) {
					nodes.push_back(state.second);
					state.second = state.second->prev;
				}
				reverse(nodes.begin(), nodes.end());
				uint128 cur = encode<uint128, true>(initial_str);
				for (auto node : nodes) {
					cur = rules[node->rule].apply(cur, node->pos);
					cout << (node->rule + 1) << ' ' << (node->pos + 1) << ' ' << decode(cur)
					     << '\n';
				}

				return true;
			}
			return false;
		});
		return 0;
	}

	// meet in the middle
	unordered_map<uint128, HistoryNode *, UInt128Hash> at_middle;
	int forward_steps = target_step >> 1;
	search(forward_steps, [&](pair<uint128, HistoryNode *> state) {
		at_middle[state.first] = state.second;
		return false;
	});

	for (auto &r : rules)
		r.flip();
	swap(initial_str, final_str);
	search(target_step - forward_steps, [&](pair<uint128, HistoryNode *> state) {
		auto it = at_middle.find(state.first);
		if (it == at_middle.end()) return false;
		for (auto &r : rules)
			r.flip();
		swap(initial_str, final_str);

		HistoryNode *forward_node = it->second;
		vector<HistoryNode *> nodes;
		while (forward_node) {
			nodes.push_back(forward_node);
			forward_node = forward_node->prev;
		}
		reverse(nodes.begin(), nodes.end());
		while (state.second) {
			nodes.push_back(state.second);
			state.second = state.second->prev;
		}
		uint128 cur = encode<uint128, true>(initial_str);
		for (auto node : nodes) {
			cur = rules[node->rule].apply(cur, node->pos);
			cout << (node->rule + 1) << ' ' << (node->pos + 1) << ' ' << decode(cur) << '\n';
		}
		return true;
	});

	return 0;
}
