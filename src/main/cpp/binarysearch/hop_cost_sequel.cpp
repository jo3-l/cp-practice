#include <bits/stdc++.h>

using namespace std;

const int MN = 1e5;

bool seen[MN];
unordered_map<int, vector<int>> pos;

int solve(vector<int> &nums) {
	if (nums.size() < 2) return 0;
	pos.clear();
	memset(seen, false, sizeof(seen));

	for (int i = 0; i < nums.size(); i++) {
		pos[nums[i]].push_back(i);
	}

	queue<int> q;
	q.push(0);
	seen[0] = true;
	int k = 1;
	while (!q.empty()) {
		int sz = q.size();
		while (sz--) {
			int idx = q.front();
			q.pop();
			auto it = pos.find(nums[idx]);
			if (it != pos.end()) {
				for (int &to : it->second) {
					if (to == (int)nums.size() - 1) return k;
					if (!seen[to]) {
						seen[to] = true;
						q.push(to);
					}
				}
				pos.erase(it);
			}

			for (int to : {idx + 1, idx - 1}) {
				if (to == (int)nums.size() - 1) return k;
				if (!seen[to]) {
					seen[to] = true;
					q.push(to);
				}
			}
		}
		k++;
	}
	return -1;
}