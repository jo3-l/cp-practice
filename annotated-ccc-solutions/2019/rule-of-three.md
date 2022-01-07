# CCC '19 J5 - Rule of Three

**Problem Link:** [DMOJ](https://dmoj.ca/problem/ccc19j5)

## Analysis

As the approaches required for subtasks 1-3 and 4 differ in fairly significant ways, we will discuss them separately.

> **Note:** Solving subtasks 1, 2, and 3 on DMOJ corresponds to full points (15/15) on the original contest. Subtask 4 is comprised of additional, harder test data that is DMOJ-specific.

## Subtasks 1, 2, and 3

Model the problem as a directed graph, rooted at the initial string. For each vertex, add outgoing edges to strings resulting from applying any valid substitution rule onto the string.

The problem now simplifies to finding a path from the root to $F$ which have length $S$. This may be done by traversing all paths of the graph that have length $S$ and stopping once a path that ends at $F$ is found, using either depth-first search or breadth-first search. (Depth-first search is significantly less finnicky to get right though.)

To print out the exact sequence of substitutions, either maintain a stack of previous states (for DFS) or a dictionary $parent$ where $parent[state]$ is the parent state of $state$ (for BFS.)

In order to not TLE, you may wish to skip handling strings that have already been visited. Note that you need to maintain a separate set of visited strings _for each step._ This is because a valid sequence of substitutions may return to the same string more than once. Alternatively, select your favorite optimization from the bucket list given below for Subtask 4.

### DFS-Based Implementation (C++)

```cpp
#include <bits/stdc++.h>

using namespace std;

struct Rule {
	string apply(int pos, string& s) {
		return s.substr(0, pos) + to + s.substr(pos + from.size());
	}
	string from, to;
};

int max_step;
string initial_seq, final_seq;
Rule rules[3];

struct State {
	int rule_num, pos;
};

unordered_set<string> seen[20];
vector<State> hist;
bool search(int step, string& cur) {
	if (step == max_step) return cur == final_seq;
	for (int rule_num = 1; rule_num <= 3; rule_num++) {
		Rule& rule = rules[rule_num - 1];
		for (int pos = cur.find(rule.from); pos != string::npos; pos = cur.find(rule.from, pos + 1)) {
			string nxt = rule.apply(pos, cur);
			if (!seen[step].count(nxt)) {
				seen[step].insert(nxt);
				hist.push_back({rule_num, pos});
				if (search(step + 1, nxt)) return true;
				hist.pop_back();
			}
		}
	}
	return false;
}

int main() {
	for (int i = 0; i < 3; i++) cin >> rules[i].from >> rules[i].to;
	cin >> max_step >> initial_seq >> final_seq;
	bool found = search(0, initial_seq);
	assert(found);
	string cur = initial_seq;
	for (State& state : hist) {
		cur = rules[state.rule_num - 1].apply(state.pos, cur);
		cout << state.rule_num << ' ' << state.pos + 1 << ' ' << cur << '\n';
	}
	return 0;
}
```

## Subtask 4

Subtask 4 entails a nefarious amount of optimization. The primary issue is that the additional test data contains cases which cause an exponential blowup in the number of states; though this cannot be avoided what can be done is helping the search algorithm explore less states before arriving at a correct answer.

Here are a list of suggestions for optimizations.
(Note that you will likely need to implement a majority of them rather than just one to pass.)

- Use 64-bit integers to represent strings (which then allows applying substitutions in $\mathcal{O}(1)$ using bit manipulation.) It can be shown that all intermediate strings in sequences of substitutions that solve the problem given the constraints must be less than 64 characters in length making overflow not an issue.
- Discard intermediate strings that cannot possibly result in the final string immediately, based on the change in A/B counts after applying a substitution rule and the change in A/B count of the final string compared to the current string.
- If using BFS, consider the meet-in-the-middle trick.
  - Also consider trying a DFS implementation. It may be easier to optimize.
- Always go from the longer string to the shorter string (i.e., swap the starting and final sequence if needed.)
- Use `gp_hash_table` as opposed to `unordered_set` (slightly faster.) Alternatively, write your own hash table.
- If using DFS, try applying rules near the middle of the string as opposed to the start/end. Alternatively, randomize. This makes a huge difference in the average case (for whatever reason.) If you have a logical explanation as to why this is the case, I'm curious -- please open an issue!

### Implementation (C++)

[See here](../../src/main/cpp/ccc/2019/rule_of_three.cpp).

## Time Complexity

No idea -- it's bounded by the number of distinct vertices in the graph that are at most $S$ away from the root, but that's hard to calculate (without giving extremely vague bounds.)

## Space Complexity

No idea; again, see above.
