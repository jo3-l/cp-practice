package binarysearch;

public class InvertTree {
    public Tree solve(Tree root) {
        if (root == null) return root;
        if (root.left != null) root.left = solve(root.left);
        if (root.right != null) root.right = solve(root.right);
        Tree tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
