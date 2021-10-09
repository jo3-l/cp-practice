package binarysearch;

import java.util.PriorityQueue;
import java.util.Queue;

public class KThSmallestInABinarySearchTree {
    private Queue<Integer> minHeap = new PriorityQueue<>();

    public int solve(Tree root, int k) {
        go(root);
        int l = 0;
        for (int i = 0; i <= k; i++) l = minHeap.poll();
        return l;
    }

    private void go(Tree root) {
        if (root != null) {
            minHeap.add(root.val);
            go(root.left);
            go(root.right);
        }
    }

    private static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
