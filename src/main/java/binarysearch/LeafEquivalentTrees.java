package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class LeafEquivalentTrees {
    public boolean solve(Tree r0, Tree r1) {
        List<Integer> l0 = new ArrayList<>();
        go(r0, l0);
        List<Integer> l1 = new ArrayList<>();
        go(r1, l1);
        return l0.equals(l1);
    }

    private void go(Tree t, List<Integer> leaves) {
        if (t == null) return;
        if (t.left == t.right) {
            leaves.add(t.val);
            return;
        }
        go(t.left, leaves);
        go(t.right, leaves);
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
