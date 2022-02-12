#include <bitset>
#include <cstdio>
#include <deque>

using namespace std;

bitset<65536> seen;
deque<uint16_t> cur_run;
deque<uint16_t> optimal_ans;

int main() {
	for (uint16_t x;;) {
		scanf("%hu", &x);
		if (x == 0) break;
		if (seen[x]) {
			bool optimal = cur_run.size() > optimal_ans.size();
			if (optimal) optimal_ans.clear();
			while (seen[x]) {
				if (optimal) optimal_ans.push_back(cur_run.front());
				seen[cur_run.front()] = false;
				cur_run.pop_front();
			}

			if (optimal) optimal_ans.insert(optimal_ans.end(), cur_run.begin(), cur_run.end());
		}
		cur_run.push_back(x);
		seen[x] = true;
	}

	if (cur_run.size() > optimal_ans.size()) swap(cur_run, optimal_ans);
	for (uint16_t x : optimal_ans) printf("%hu\n", x);
	return 0;
}
