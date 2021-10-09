package binarysearch;

import java.util.*;

public class LevelOrderAlternating {
    public int[] solve(Tree root) {
        Deque<Tree> deque = new LinkedList<>();
        deque.addFirst(root);
        List<Integer> res = new ArrayList<>();

        boolean isLtr = true;
        while (!deque.isEmpty()) {
            int breadth = deque.size();
            while (breadth-- > 0) {
                Tree v = isLtr ? deque.removeFirst() : deque.removeLast();
                res.add(v.val);

                if (isLtr) {
                    if (v.left != null) deque.addLast(v.left);
                    if (v.right != null) deque.addLast(v.right);
                } else {
                    if (v.right != null) deque.addFirst(v.right);
                    if (v.left != null) deque.addFirst(v.left);
                }
            }

            isLtr = !isLtr;
        }

        int[] xs = new int[res.size()];
        for (int i = 0; i < res.size(); i++) xs[i] = res.get(i);
        return xs;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
