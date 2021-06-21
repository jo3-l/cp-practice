package binarysearch;

import java.util.PriorityQueue;
import java.util.Queue;

public class BSTIterator {
    private Queue<Integer> pq = new PriorityQueue<>();

    public BSTIterator(Tree root) {
        init(root);
    }

    public int next() {
        return pq.poll();
    }

    public boolean hasnext() {
        return !pq.isEmpty();
    }

    private void init(Tree node) {
        if (node == null) return;
        pq.add(node.val);
        init(node.right);
        init(node.left);
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
