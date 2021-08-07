package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class VerticalLinesInBinaryTree {
    public int solve(Tree root) {
        Set<Integer> locs = new HashSet<>();
        go(root, 0, locs);
        return locs.size();
    }

    private void go(Tree root, int loc, Set<Integer> locs) {
        if (root == null) return;
        locs.add(loc);
        go(root.left, loc - 1, locs);
        go(root.right, loc + 1, locs);
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
