package binarysearch;

public class TreeWithDistinctParities {
    private int n = 0;

    public int solve(Tree root) {
        go(root);
        return n;
    }

    public int[] go(Tree root) {
        if (root == null) return new int[2];
        int[] l = go(root.left);
        int[] r = go(root.right);
        int ls = (root.left == null ? 0 : root.left.val) + l[0] + l[1];
        int rs = (root.right == null ? 0 : root.right.val) + r[0] + r[1];
        if (root.left != null && root.right != null && (ls & 1) + (rs & 1) == 1) n++;
        return new int[]{ls, rs};
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
