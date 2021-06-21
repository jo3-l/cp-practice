package binarysearch;

public class SumOfNodesWithEvenGrandparentValues {
    private int total = 0;
    public int solve(Tree root) {
        go(root, null, null);
        return total;
    }

    private void go(Tree root, Tree parent, Tree grandparent) {
        if (root == null) return;
        if (grandparent != null && (grandparent.val & 1) == 0) total += root.val;
        Tree tmp = parent;
        parent = root;
        grandparent = tmp;
        go(root.left, parent, grandparent);
        go(root.right, parent, grandparent);
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
