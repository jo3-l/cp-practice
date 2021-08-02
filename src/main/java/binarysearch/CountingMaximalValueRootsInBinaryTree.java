package binarysearch;

public class CountingMaximalValueRootsInBinaryTree {
    private int n;

    public int solve(Tree root) {
        go(root);
        return n;
    }

    private int go(Tree root) {
        if (root == null) return Integer.MIN_VALUE;
        int m = Math.max(go(root.left), go(root.right));
        if (root.val >= m) {
            n++;
            return root.val;
        }
        return m;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
