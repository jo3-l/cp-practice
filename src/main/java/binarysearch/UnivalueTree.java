package binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class UnivalueTree {
    public boolean solve(Tree root) {
        if (root == null) return true;

        Queue<Tree> queue = new ArrayDeque<>();
        queue.add(root);
        int v = root.val;
        while (!queue.isEmpty()) {
            Tree t = queue.poll();
            if (t.val != v) return false;
            if (t.left != null) queue.add(t.left);
            if (t.right != null) queue.add(t.right);
        }
        return true;
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
