package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class SumOfTwoNumbersInBST {
    private Set<Integer> aElem = new HashSet<>();
    private Set<Integer> bElem = new HashSet<>();

    public boolean solve(Tree a, Tree b, int target) {
        go(a, true);
        go(b, false);
        for (int v : aElem) {
            if (bElem.contains(target - v)) return true;
        }
        return false;
    }

    private void go(Tree t, boolean isA) {
        if (t== null) return;
        if (isA) aElem.add(t.val);
        else bElem.add(t.val);
        go(t.right, isA);
        go(t.left, isA);
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
