#include <bits/stdc++.h>

using namespace std;

unordered_map<string, string> short_forms{{"CU", "see you"},
					  {":-)", "I'm happy"},
					  {":-(", "I'm unhappy"},
					  {";-)", "wink"},
					  {":-P", "stick out my tongue"},
					  {"(~.~)", "sleepy"},
					  {"TA", "totally awesome"},
					  {"CCC", "Canadian Computing Competition"},
					  {"CUZ", "because"},
					  {"TY", "thank-you"},
					  {"YW", "you're welcome"},
					  {"TTYL", "talk to you later"}};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	string s;
	while (s != "TTYL") {
		cin >> s;
		auto it = short_forms.find(s);
		cout << (it == short_forms.end() ? s : it->second) << '\n';
	}

	return 0;
}