package binarysearch;

public class SubtreeWithMaximumValue {
    private int max = Integer.MIN_VALUE;

    public int solve(Tree root) {
        go(root);
        return max;
    }

    private int go(Tree t) {
        if (t == null) {
            max = Math.max(max, 0);
            return 0;
        }

        int left = go(t.left);
        int right = go(t.right);
        max = Math.max(
                max,
                Math.max(
                        Math.max(
                                t.val + left + right,
                                left
                        ),
                        right
                )
        );
        return t.val + left + right;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
