#include <bits/stdc++.h>

using namespace std;

int solve(vector<vector<int>> &costs) {
	vector<tuple<int, int, int>> aux(costs.size());
	for (int i = 0; i < costs.size(); i++) {
		aux[i] = {costs[i][0] - costs[i][1], costs[i][0], i};
	}
	sort(aux.begin(), aux.end());
	int cost = 0;
	for (int i = 0; i < aux.size() >> 1; i++) cost += get<1>(aux[i]);
	for (int i = aux.size() >> 1; i < costs.size(); i++) cost += costs[get<2>(aux[i])][1];
	return cost;
}