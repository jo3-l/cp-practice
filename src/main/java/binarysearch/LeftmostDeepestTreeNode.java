package binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeftmostDeepestTreeNode {
    public int solve(Tree root) {
        Queue<Tree> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int d = q.size();
            int first = q.peek().val;
            while (d-- > 0) {
                Tree v = q.poll();
                if (d == 0 && q.isEmpty() && v.left == null && v.right == null) {
                    return first;
                }
                if (v.left != null) q.add(v.left);
                if (v.right != null) q.add(v.right);
            }
        }
        return -1;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
