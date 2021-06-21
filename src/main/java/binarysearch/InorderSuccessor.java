package binarysearch;

public class InorderSuccessor {
    private int best = Integer.MAX_VALUE;

    public int solve(Tree root, int t) {
        go(root, t);
        return best;
    }

    private void go(Tree root, int t) {
        if (root == null) return;
        if (root.val > t) {
            best = Math.min(root.val, best);
            go(root.left, t);
        } else {
            go(root.right, t);
        }
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
