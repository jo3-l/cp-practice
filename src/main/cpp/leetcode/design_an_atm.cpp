#include <bits/stdc++.h>

using namespace std;

class ATM {
public:
	ATM() = default;

	void deposit(vector<int> counts) {
		for (int i = 0; i < 5; i++) supply[i] += counts[i];
	}

	vector<int> withdraw(int amount) {
		static const int denoms[]{20, 50, 100, 200, 500};

		vector<int> withdrawn(5);
		for (int i = 4; i >= 0 && amount > 0; i--) {
			withdrawn[i] = min<int64_t>(supply[i], amount / denoms[i]);
			amount -= withdrawn[i] * denoms[i];
		}
		if (amount != 0) return {-1};
		for (int i = 0; i < 5; i++) supply[i] -= withdrawn[i];
		return withdrawn;
	}

private:
	array<int64_t, 5> supply{};
};
