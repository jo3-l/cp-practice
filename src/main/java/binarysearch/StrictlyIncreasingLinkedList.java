package binarysearch;

public class StrictlyIncreasingLinkedList {
    public boolean solve(LLNode head) {
        if (head == null) return true;

        int lastVal = head.val;
        for (LLNode node = head.next; node != null; node = node.next) {
            if (node.val <= lastVal) return false;
            lastVal = node.val;
        }

        return true;
    }

    public static class LLNode {
        public int val;
        public LLNode next;
    }
}
