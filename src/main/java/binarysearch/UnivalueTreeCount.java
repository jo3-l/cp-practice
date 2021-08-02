package binarysearch;

public class UnivalueTreeCount {
    private int x = 0;

    public int solve(Tree root) {
        go(root);
        return x;
    }

    private boolean go(Tree root) {
        if (root == null) return true;
        boolean lok = go(root.left);
        boolean rok = go(root.right);
        if (((root.left == null || root.val == root.left.val) && lok) && ((root.right == null || root.val == root.right.val) && rok)) {
            x++;
            return true;
        }
        return false;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
