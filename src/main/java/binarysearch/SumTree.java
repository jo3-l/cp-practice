package binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class SumTree {
    public boolean solve(Tree root) {
        if (root == null) return true;
        Queue<Tree> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Tree t = q.poll();
            if (t.left == t.right) continue;
            int total = (t.left == null ? 0 : t.left.val) + (t.right == null ? 0 : t.right.val);
            if (total != t.val) return false;
            if (t.left != null) q.add(t.left);
            if (t.right != null) q.add(t.right);
        }
        return true;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
