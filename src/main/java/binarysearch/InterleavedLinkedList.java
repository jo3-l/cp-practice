package binarysearch;

public class InterleavedLinkedList {
    public LLNode solve(LLNode l0, LLNode l1) {
        if (l0 == l1) return null;

        LLNode head = new LLNode();
        LLNode cur = head;
        LLNode prev = null;
        while (l0 != null && l1 != null) {
            cur.val = l0.val;
            cur = cur.next = new LLNode();
            cur.val = l1.val;
            prev = cur;
            cur = cur.next = new LLNode();
            l0 = l0.next;
            l1 = l1.next;
        }

        LLNode lv = l0 == null ? l1 : l0;
        while (lv != null) {
            prev = cur;
            cur.val = lv.val;
            cur = cur.next = new LLNode();
            lv = lv.next;
        }
        prev.next = null;

        return head;
    }

    public static class LLNode {
        public int val;
        public LLNode next;
    }
}
