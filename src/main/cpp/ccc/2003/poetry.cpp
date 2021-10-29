#include <bits/stdc++.h>

using namespace std;

string last[4];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n;
	cin >> n >> ws;
	while (n--) {
		for (int i = 0; i < 4; i++) {
			string line;
			getline(cin, line);
			transform(line.begin(), line.end(), line.begin(), ::tolower);
			auto space_pos = line.find_last_of(' ');
			auto last_vowel_pos = line.find_last_of("aeiou");
			last[i] = line.substr(last_vowel_pos <= space_pos ? space_pos + 1 : last_vowel_pos);
		}

		if (last[0] == last[1] && last[1] == last[2] && last[2] == last[3]) cout << "perfect" << '\n';
		else if (last[0] == last[1] && last[2] == last[3]) cout << "even" << '\n';
		else if (last[0] == last[2] && last[1] == last[3]) cout << "cross" << '\n';
		else if (last[0] == last[3] && last[1] == last[2]) cout << "shell" << '\n';
		else cout << "free" << '\n';
	}

	return 0;
}