#include <bits/stdc++.h>

using namespace std;

class Tree {
public:
	int val;
	Tree *left;
	Tree *right;
};

int traverse(Tree *cur, int acc) {
	if (cur->left == cur->right) return acc * 10 + cur->val;
	int ans = 0;
	if (cur->left) ans += traverse(cur->left, acc * 10 + cur->val);
	if (cur->right) ans += traverse(cur->right, acc * 10 + cur->val);
	return ans;
}

int solve(Tree *root) { return root ? traverse(root, 0) : 0; }