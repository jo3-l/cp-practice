package binarysearch;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLinkedList {
    public LLNode solve(Tree root) {
        if (root == null) return null;

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        LLNode head = new LLNode();
        LLNode cur = head;
        LLNode prev = null;
        while (!queue.isEmpty()) {
            Tree v = queue.poll();
            cur.val = v.val;
            prev = cur;
            cur = cur.next = new LLNode();

            if (v.left != null) queue.add(v.left);
            if (v.right != null) queue.add(v.right);
        }

        if (prev != null) prev.next = null;
        return head;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }

    public static class LLNode {
        public int val;
        public LLNode next;
    }
}
