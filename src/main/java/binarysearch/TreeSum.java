package binarysearch;

public class TreeSum {
    public int solve(Tree root) {
        if (root == null) return 0;
        return root.val + solve(root.left) + solve(root.right);
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
