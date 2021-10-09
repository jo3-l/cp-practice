package binarysearch;

public class LinkedListLength {
    public int solve(LLNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }

        return len;
    }

    public static class LLNode {
        public int val;
        public LLNode next;
    }
}
