package binarysearch;

public class HeightBalancedTree {
    public boolean solve(Tree root) {
        if (root == null) return true;
        int diff = Math.abs(height(root.left) - height(root.right));
        return (diff == 0 || diff == 1) && solve(root.left) && solve(root.right);
    }

    public int height(Tree root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
