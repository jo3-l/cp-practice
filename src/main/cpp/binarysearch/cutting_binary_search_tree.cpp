#include <bits/stdc++.h>

using namespace std;

struct Tree {
	int val;
	Tree *left, *right;
};

Tree *solve(Tree *root, int lo, int hi) {
	if (!root) return nullptr;
	if (root->val < lo) return solve(root->right, lo, hi);
	if (root->val > hi) return solve(root->left, lo, hi);
	root->left = solve(root->left, lo, hi);
	root->right = solve(root->right, lo, hi);
	return root;
}