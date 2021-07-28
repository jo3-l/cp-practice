package binarysearch;

public class CountNodesInCompleteBinaryTree {
    int n;

    public int solve(Tree root) {
        go(root);
        return n;
    }

    private void go(Tree root) {
        if (root != null) {
            n++;
            go(root.left);
            go(root.right);
        }
    }

    private static class Tree {
        int val;
        Tree left;
        Tree right;
    }
}
