package binarysearch;

public class CentralLinkedList {
    public int solve(LLNode node) {
        int len = 0;
        for (LLNode node_ = node; node_ != null; node_ = node_.next) len++;

        int n = 0;
        int mid = len >> 1;
        for (; node != null; node = node.next) {
            if (n++ == mid) return node.val;
        }
        return -1;
    }

    public static class LLNode {
        public int val;
        public LLNode next;
    }
}
