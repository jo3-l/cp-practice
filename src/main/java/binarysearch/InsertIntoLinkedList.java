package binarysearch;

public class InsertIntoLinkedList {
    public LLNode solve(LLNode head, int pos, int val) {
        if (pos == 0) {
            LLNode l = new LLNode();
            l.val = val;
            l.next = head;
            return l;
        }

        LLNode n = head;
        for (int i = 1; i < pos; i++) {
            n = n.next;
        }

        LLNode p = n.next;
        n.next = new LLNode();
        n.next.val = val;
        n.next.next = p;
        return head;
    }

    private static class LLNode {
        public int val;
        public LLNode next;
    }
}
