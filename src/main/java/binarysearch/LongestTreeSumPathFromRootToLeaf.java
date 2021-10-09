package binarysearch;

public class LongestTreeSumPathFromRootToLeaf {
    private int len = Integer.MIN_VALUE;
    private int sum = Integer.MIN_VALUE;

    public int solve(Tree root) {
        go(root, 0, 0);
        return sum;
    }

    private void go(Tree root, int len, int sum) {
        if (root == null) return;
        sum += root.val;
        if (
                (len == this.len && sum > this.sum)
                || (len > this.len)
        ) {
            this.len = len;
            this.sum = sum;
        }

        go(root.left, len + 1, sum);
        go(root.right, len + 1, sum);
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
