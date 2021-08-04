package binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TreeColoring {
    private Map<Integer, Integer> colors = new HashMap<>();

    public boolean solve(Tree root) {
        go(root);
        Iterator<Integer> it = colors.values().iterator();
        int[] available = new int[]{it.hasNext() ? it.next() : 0, it.hasNext() ? it.next() : 0};
        return solve(root, 0, Arrays.copyOf(available, available.length))
                || solve(root, 1, available);
    }

    public boolean solve(Tree root, int parent, int[] available) {
        if (root == null) return true;
        return available[parent ^ 1]-- > 0
            && solve(root.left, parent ^ 1, available)
                && solve(root.right, parent ^ 1, available);
    }

    private void go(Tree root) {
        if (root != null) {
            colors.merge(root.val, 1, Integer::sum);
            go(root.left);
            go(root.right);
        }
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
