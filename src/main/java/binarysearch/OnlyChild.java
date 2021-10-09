package binarysearch;

public class OnlyChild {
    private int count = 0;

    public int solve(Tree root) {
        go(root, null);
        return count;
    }

    private void go(Tree t, Tree parent) {
        if (t == null) return;
        if (parent != null) {
            int ctr = (parent.left == null ? 0 : 1)
                    + (parent.right == null ? 0 : 1);
            if (ctr == 1) count++;
        }
        go(t.left, t);
        go(t.right, t);
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
