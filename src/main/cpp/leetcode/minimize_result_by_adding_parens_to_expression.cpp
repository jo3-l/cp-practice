#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
	string minimizeResult(string expression) {
		int plus_pos = expression.find("+");
		int best = numeric_limits<int>::max();
		string best_str;
		for (int insert_left = 0; insert_left < plus_pos; insert_left++) {
			for (int insert_right = plus_pos + 1; insert_right < expression.size(); insert_right++) {
				string before_str = expression.substr(0, insert_left);
				int before = before_str.empty() ? 1 : stoi(before_str);

				string mid_left = expression.substr(insert_left, plus_pos - insert_left);
				string mid_right = expression.substr(plus_pos + 1, insert_right - plus_pos);
				int mid = stoi(mid_left) + stoi(mid_right);

				string after_str = expression.substr(insert_right + 1, expression.size() - insert_right - 1);
				int after = after_str.empty() ? 1 : stoi(after_str);

				if (before * mid * after <= best) {
					best = before * mid * after;
					best_str = before_str + "("s + mid_left + "+"s + mid_right + ")"s + after_str;
				}
			}
		}
		return best_str;
	}
};