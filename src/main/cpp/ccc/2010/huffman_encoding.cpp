#include <bits/stdc++.h>

using namespace std;

struct TrieNode {
	TrieNode *children[2];
	char val;
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int k;
	cin >> k;
	TrieNode *root = new TrieNode{};
	while (k--) {
		char v;
		string s;
		cin >> v >> s;
		TrieNode *cur = root;
		for (int i = 0; i < s.size(); i++) {
			if (!cur->children[s[i] - '0']) cur->children[s[i] - '0'] = new TrieNode{};
			cur = cur->children[s[i] - '0'];
		}
		cur->val = v;
	}

	string enc;
	cin >> enc;
	int i = 0;

	string ans;
	while (i < enc.size()) {
		TrieNode *cur = root;
		while (i < enc.size() && !cur->val) cur = cur->children[enc[i++] - '0'];
		ans.push_back(cur->val);
	}
	cout << ans << '\n';
	return 0;
}