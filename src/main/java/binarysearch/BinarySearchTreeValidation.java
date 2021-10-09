package binarysearch;

public class BinarySearchTreeValidation {
    public boolean solve(Tree root) {
        return go(root) != null;
    }

    public int[] go(Tree root) {
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        if (root.left != null && root.left.val >= root.val) return null;
        if (root.right != null && root.right.val <= root.val) return null;
        int[] rd = go(root.right);
        if (rd == null) return null;
        int[] ld = go(root.left);
        if (ld == null) return null;
        if ((root.left != null && ld[1] >= root.val) || (root.right != null && rd[0] <= root.val)) return null;
        return new int[]{root.left == null ? root.val : ld[0], root.right == null ? root.val : rd[1]};
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
