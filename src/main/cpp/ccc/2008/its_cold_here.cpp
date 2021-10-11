#include <bits/stdc++.h>

using namespace std;

constexpr int INF = 0x3f3f3f3f;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string min_city;
	int min_temp = INF;

	string city;
	int temp;
	while (city != "Waterloo") {
		cin >> city >> temp;
		if (temp < min_temp) {
			min_temp = temp;
			min_city = city;
		}
	}

	cout << min_city << '\n';
	return 0;
}