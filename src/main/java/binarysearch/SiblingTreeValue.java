package binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class SiblingTreeValue {
    public int solve(Tree root, int k) {
        Queue<Tree> q =new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int b = q.size();
            int lval = -1;
            while (b-- > 0) {
                Tree t = q.poll();
                if (t.val == k) {
                    return (b & 1) == 1
                            ? q.poll().val
                            : lval;
                }
                lval = t.val;
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
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
