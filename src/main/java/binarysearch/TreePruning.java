package binarysearch;

public class TreePruning {
    public Tree solve(Tree root) {
        if (root == null || allZero(root)) return null;
        if (allZero(root.left)) root.left = null;
        root.left = solve(root.left);
        if (allZero(root.right)) root.right = null;
        root.right = solve(root.right);
        return root;
    }

    private boolean allZero(Tree root) {
        if (root == null) return true;
        if (root.val != 0) return false;
        return allZero(root.right) && allZero(root.left);
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
