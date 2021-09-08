#include <bits/stdc++.h>

using namespace std;

class MiddleOperableDeque {
      public:
	void appendLeft(int val) {
		left.push_front(val);
		balance();
	}

	int popLeft() {
		if (left.empty()) {
			if (right.empty()) return -1;
			int v = right.front();
			right.pop_front();
			balance();
			return v;
		}

		int v = left.front();
		left.pop_front();
		balance();
		return v;
	}

	void append(int val) {
		right.push_back(val);
		balance();
	}

	int pop() {
		if (right.empty()) return -1;
		int v = right.back();
		right.pop_back();
		balance();
		return v;
	}

	void appendMiddle(int val) {
		int size = left.size() + right.size();
		left.push_back(val);
		balance();
	}

	int popMiddle() {
		int size = left.size() + right.size();
		if (size == 0) return -1;
		if (size & 1) {
			int v = right.front();
			right.pop_front();
			return v;
		}
		int v = left.back();
		left.pop_back();
		return v;
	}

      private:
	deque<int> left, right;

	void balance() {
		if (left.size() > right.size()) {
			int v = left.back();
			left.pop_back();
			right.push_front(v);
		} else if (right.size() > (int)left.size() + 1) {
			int v = right.front();
			right.pop_front();
			left.push_back(v);
		}
	}
};