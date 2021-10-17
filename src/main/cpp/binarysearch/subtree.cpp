#include <bits/stdc++.h>

using namespace std;

struct Tree {
	int val;
	Tree *left;
	Tree *right;
};

bool solve(Tree *root, Tree *tmpl) {
	if (!root || !tmpl) return root == tmpl;
	return (root->val == tmpl->val && solve(root->left, tmpl->left) && solve(root->right, tmpl->right)) || solve(root->right, tmpl) ||
	       solve(root->left, tmpl);
}