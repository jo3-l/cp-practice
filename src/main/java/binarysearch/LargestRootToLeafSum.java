package binarysearch;

public class LargestRootToLeafSum {
    public int solve(Tree root) {
        return run(root, 0);
    }

    public int run(Tree node, int n) {
        if (node == null) return n;
        int x = n + node.val;
        if (node.left != null) x = run(node.left, x);
        if (node.right != null) x = Math.max(x, run(node.right, n + node.val));
        return x;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
