package binarysearch;

public class LargestBinarySearchSubtreeInNodes {
    public Tree solve(Tree root) {
        return dfs(root).best;
    }

    private Result dfs(Tree root) {
        if (root == null) return new Result(null, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        Result lr = dfs(root.left);
        Result rr = dfs(root.right);
        int min = Math.min(lr.min,Math.min(rr.min, root.val));
        int max = Math.max(lr.max, Math.max(rr.max, root.val));
        if (lr.max < root.val && root.val < rr.min && lr.best == root.left && rr.best == root.right) {
            return new Result(root, lr.count + rr.count + 1, max, min);
        }
        if (lr.count > rr.count) return new Result(lr.best, lr.count, max, min);
        return new Result(rr.best, rr.count, max, min);
    }

    private static class Result {
        Tree best;
        int count;
        int max;
        int min;

        Result(Tree best, int count, int max, int min) {
            this.best = best;
            this.count = count;
            this.max = max;
            this.min = min;
        }
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
