package binarysearch;

public class SearchInAVirtuallyCompleteBinaryTree {
    public boolean solve(Tree root, int target) {
        if (root == null) return false;
        return root.val == target || solve(root.left, target) || solve(root.right, target);
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
