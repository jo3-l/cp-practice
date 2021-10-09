package binarysearch;

public class CountBSTNodesInRange {
    private int total = 0;

    public int solve(Tree root, int lo, int hi) {
        go(root, lo, hi);
        return total;
    }

    private void go(Tree root, int lo, int hi) {
        if (root == null) return ;
        int v = root.val;
        if (v < lo) {
            // no need to search in left subtree
            go(root.right, lo, hi);
        } else if (v > hi) {
            // no need to search in right subtree
            go(root.left, lo, hi);
        } else {
            go(root.right, lo, hi);
            go(root.left, lo, hi);
            total++;
        }
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
