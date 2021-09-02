package binarysearch;

public class RotateLinkedListByK {
    public LLNode solve(LLNode node, int k) {
        if (k == 0) return node;

        // make the linked list circular
        LLNode tail = node;
        int l = 0;
        while (tail != null && tail.next != null) {
            tail = tail.next;
            l++;
        }
        if (tail == null) l++;
        tail.next = node;

        LLNode fast = node;
        for (int i = 0; i < k; i++) fast = fast.next;
        LLNode head = node;
        while (fast != node) {
            head = head.next;
            fast = fast.next;
        }

        LLNode newTail = head;
        for (int i = 0; i < l; i++) newTail = newTail.next;
        newTail.next = null;
        return head;
    }

    private static class LLNode {
        public int val;
        public LLNode next;
    }
}
