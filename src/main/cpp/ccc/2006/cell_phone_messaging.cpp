#include <bits/stdc++.h>

using namespace std;

const char categories[] = "22233344455566677778889999";
const char clicks[] = "12312312312312312341231234";

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	for (cin >> s; s != "halt"; cin >> s) {
		int time = 0;
		for (int i = 0; i < s.size(); i++) {
			if (i > 0 && categories[s[i] - 'a'] == categories[s[i - 1] - 'a']) time += 2;
			time += clicks[s[i] - 'a'] - '0';
		}
		cout << time << '\n';
	}

	return 0;
}