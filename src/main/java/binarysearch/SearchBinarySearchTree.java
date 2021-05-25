package binarysearch;

public class SearchBinarySearchTree {
    public boolean solve(Tree root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;
        if (val > root.val) return solve(root.right, val);
        return solve(root.left, val);
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
