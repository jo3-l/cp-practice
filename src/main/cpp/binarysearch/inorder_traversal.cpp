#include <bits/stdc++.h>

using namespace std;

struct Tree {
	int val;
	Tree *left, *right;
};

void go(Tree* root, vector<int>& acc) {
    if (!root) return;
    go(root->left, acc);
    acc.push_back(root->val);
    go(root->right, acc);
}

vector<int> solve(Tree* root) {
    vector<int> ans;
    go(root, ans);
    return ans;
}