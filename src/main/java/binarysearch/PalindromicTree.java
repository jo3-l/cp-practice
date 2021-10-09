package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class PalindromicTree {
    private List<Integer> ls = new ArrayList<>();

    public boolean solve(Tree root) {
        go(root);
        for (int i = 0; i < ls.size() >> 1; i++) {
            if (!ls.get(i).equals(ls.get(ls.size() - i - 1))) return false;
        }
        return true;
    }

    private void go(Tree root) {
        if (root == null) return;
        go(root.left);
        ls.add(root.val);
        go(root.right);
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
