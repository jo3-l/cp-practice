package binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class NextNodeOnItsRight {
    public Tree solve(Tree root, int target) {
        Queue<Tree> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            int b = q.size();
            while (b-- > 0) {
                Tree v = q.poll();
                if (v.val == target) {
                    return b == 0 ? null : q.poll();
                }

                if (v.left != null) q.add(v.left);
                if (v.right != null) q.add(v.right);
            }
        }

        return null;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
