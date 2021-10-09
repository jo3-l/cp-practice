package binarysearch;

public class PartitionTree {
    private int[] ret;

    public int[] solve(Tree root) {
        ret = new int[2];
        go(root);
        return ret;
    }

    private void go(Tree root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            ret[0]++;
        } else {
            ret[1]++;
            go(root.left);
            go(root.right);
        }
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
