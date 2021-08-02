package binarysearch;

public class LargestDifferenceBetweenNodeAndADescent {
    private int mabs = 0;

    public int solve(Tree root) {
        go(root);
        return mabs;
    }

    // returns [min, max]
    private int[] go(Tree root) {
        final int INF = (int) 1e9 + 5;
        if (root == null) return null;
        int[] lr = go(root.left);
        int[] rr = go(root.right);
        int ld = lr == null
                ? Integer.MIN_VALUE
                : Math.max(Math.abs(root.val - lr[0]), Math.abs(root.val - lr[1]));
        int rd = rr == null
                ? Integer.MIN_VALUE
                : Math.max(Math.abs(root.val - rr[0]), Math.abs(root.val - rr[1]));
        mabs = Math.max(mabs, Math.max(ld, rd));
        int min = Math.min(root.val, Math.min(lr == null ? Integer.MAX_VALUE : lr[0], rr == null ? Integer.MAX_VALUE : rr[0]));
        int max = Math.max(root.val, Math.max(lr == null ? Integer.MIN_VALUE : lr[1], rr == null ? Integer.MIN_VALUE : rr[1]));
        return new int[]{min, max};
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
