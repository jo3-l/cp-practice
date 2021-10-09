package binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class TwinTrees {
    public boolean solve(Tree root0, Tree root1) {
        if ((root0 == null) != (root1 == null)) return false;

        Queue<Tree> q0 = new ArrayDeque<>();
        q0.add(root0);
        Queue<Tree> q1 = new ArrayDeque<>();
        q1.add(root1);
        while (!q0.isEmpty() && !q1.isEmpty()) {
            Tree t0 = q0.poll();
            Tree t1 = q1.poll();
            if (t0.val != t1.val) return false;
            if (t0.left != null) {
                if (t1.left == null) return false;
                q0.add(t0.left);
            }
            if (t0.right != null) {
                if (t1.right == null) return false;
                q0.add(t0.right);
            }
            if (t1.left != null) {
                if (t0.left == null) return false;
                q1.add(t1.left);
            }
            if (t1.right != null) {
                if (t0.right == null) return false;
                q1.add(t1.right);
            }
        }

        return q0.isEmpty() == q1.isEmpty();
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
