package binarysearch;

public class SumOfRightLeaves {
    private int total = 0;
    public int solve(Tree root) {
        go(root, false);
        return total;
    }

    private void go(Tree node, boolean isRight) {
        if (node == null) return;
        if (isRight && node.right == null && node.left == null) total += node.val;
        go(node.right, true);
        go(node.left, false);
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
