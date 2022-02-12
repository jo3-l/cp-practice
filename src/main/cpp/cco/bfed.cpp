#include <bits/stdc++.h>

using namespace std;

bool is_inst(char c) {
	switch (c) {
		case '>':
		case '<':
		case '+':
		case '-':
		case '[':
		case ']':
		case '.':
			return true;
		default:
			return false;
	}
}

uint8_t mem[30'000];
int ptr;

int matching[10'000];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	cin.exceptions(cin.failbit);

	memset(matching, -1, sizeof(matching));

	string prog;
	stack<int> stk;
	for (char c; cin >> c;) {
		if (c == '#') break;
		if (is_inst(c)) {
			prog.push_back(c);
			int inst_idx = prog.size() - 1;
			if (c == '[') {
				stk.push(inst_idx);
			} else if (c == ']') {
				matching[matching[inst_idx] = stk.top()] = inst_idx;
				stk.pop();
			}
		}
	}

	for (int inst = 0; inst < prog.size();) {
		int orig_inst = inst;
		char c = prog[inst++];
		if (c == '>') {
			ptr++;
		} else if (c == '<') {
			ptr--;
		} else if (c == '+') {
			mem[ptr]++;
		} else if (c == '-') {
			mem[ptr]--;
		} else if (c == '[') {
			if (mem[ptr] == 0) inst = matching[orig_inst];
		} else if (c == ']') {
			if (mem[ptr] != 0) inst = matching[orig_inst];
		} else if (c == '.') {
			cout << char(mem[ptr]);
		}
	}

	return 0;
}