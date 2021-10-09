#include <bits/stdc++.h>

using namespace std;

const int MN = 26;
const int MM = 26;
bool done[MN][MM];

bool is_num(string &s) {
	if (s.empty()) return false;
	return all_of(s.begin() + (s.front() == '-'), s.end(), ::isdigit);
}

vector<vector<string>> solve(vector<vector<string>> &matrix) {
	int R = matrix.size(), C = matrix[0].size();
	if (R == 0) return matrix;
	memset(done, false, sizeof(done));
	vector<vector<int>> solution(R, vector<int>(C));

	function<int(int, int)> resolve_cell = [&](int i, int j) {
		if (done[i][j]) return solution[i][j];
		done[i][j] = true;
		string &cell = matrix[i][j];
		// just a number
		if (is_num(cell)) return solution[i][j] = stoi(cell);

		// reference
		if (isalpha(cell[0]))
			return solution[i][j] =
				   resolve_cell(stoi(cell.substr(1)) - 1, cell[0] - 'A');

		// formula
		int op_pos = cell.find('+');
		if (op_pos == string::npos) op_pos = cell.find('-');
		string lhs = cell.substr(1, op_pos - 1);
		int lv =
		    is_num(lhs) ? stoi(lhs) : resolve_cell(stoi(lhs.substr(1)) - 1, lhs[0] - 'A');
		string rhs = cell.substr(op_pos + 1);
		int rv =
		    is_num(rhs) ? stoi(rhs) : resolve_cell(stoi(rhs.substr(1)) - 1, rhs[0] - 'A');
		return solution[i][j] = cell[op_pos] == '+' ? lv + rv : lv - rv;
	};

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++)
			resolve_cell(i, j);
	}

	vector<vector<string>> strs(R, vector<string>(C));
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++)
			strs[i][j] = to_string(solution[i][j]);
	}
	return strs;
}