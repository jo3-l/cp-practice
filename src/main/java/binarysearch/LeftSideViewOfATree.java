package binarysearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeftSideViewOfATree {
    public int[] solve(Tree root) {
        List<Integer> view = new ArrayList<>();
        Queue<Tree> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int b = q.size();
            for (int i = 0; i < b; i++) {
                Tree t = q.poll();
                if (i == 0) view.add(t.val);
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
        }

        int[] ret = new int[view.size()];
        for (int i = 0; i < view.size(); i++) ret[i] = view.get(i);
        return ret;
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
