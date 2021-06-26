package binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class SumOfTheDeepestNodes {
    public int solve(Tree root) {
        if (root == null) return 0;

        Queue<Tree> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int h = q.size();
            int total = 0;
            while (h-- > 0) {
                Tree v = q.poll();
                total += v.val;
                if (v.left != null) q.add(v.left);
                if (v.right != null) q.add(v.right);
            }

            if (q.isEmpty()) return total;
        }
        return -1;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
