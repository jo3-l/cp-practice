package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    private List<Integer> ret = new ArrayList<>();

    public int[] solve(Tree root) {
        go(root);
        int[] rett = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) rett[i] = ret.get(i);
        return rett;
    }

    private void go(Tree root) {
        if (root == null) return;
        go(root.left);
        ret.add(root.val);
        go(root.right);
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
