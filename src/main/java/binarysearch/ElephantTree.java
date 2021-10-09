package binarysearch;

public class ElephantTree {
    public Tree solve(Tree root) {
        if (root == null) return null;
        root.val = sum(root);
        solve(root.left);
        solve(root.right);
        return root;
    }

    private int sum(Tree root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
